package com.example.service;

import com.example.model.postgre.Answer;
import com.example.model.postgre.Question;
import com.example.model.viber.BasicMessageModel;
import com.example.model.viber.DefaultResponseModel;
import com.example.model.viber.ErrorResponseModel;
import com.example.model.viber.FileMessageModel;
import com.example.model.viber.SubscribeRequestModel;
import com.example.model.viber.TextMessageModel;
import com.example.model.viber.WebhookResponseModel;
import com.example.model.viber.EventRequestModel;
import com.example.repository.AnswerRepository;
import com.example.repository.QuestionRepository;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import java.io.IOException;
import java.sql.Date;
import java.sql.Time;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import java.util.List;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Service
public class ViberServiceImpl implements ViberService {
    
    @Value("${home.domain}")
    protected String domain;
    
    @Autowired
    protected BotlibreService botlibreManager;
            
    @Autowired
    protected AnswerRepository repoAnswer;
    
    @Autowired
    protected QuestionRepository repoQuestion;
    
    @Autowired
    protected Gson gson;
    
    @Autowired
    protected ObjectMapper objectMapper;
    
    @Override
    public SubscribeRequestModel getSubscribeRequest(String incomeEvent) {
        System.out.println("End "+incomeEvent);
        // parse a question
        return this.gson.fromJson(incomeEvent, SubscribeRequestModel.class);
    }
    
    @Override
    public EventRequestModel getEventRequest(String incomeEvent) {
        // parse a question
        return this.gson.fromJson(incomeEvent, EventRequestModel.class);
    }
    
    @Override
    public String getWebhookResponse() {
        return this.gson.toJson(new WebhookResponseModel());
    }
    
    @Override
    public String getSubscribeResponse(SubscribeRequestModel subscribe) {
        // save a question
        this.repoQuestion.save(new Question(subscribe.getUser().getName(), subscribe.getMessage_token(), subscribe.getUser().getId(), subscribe.getEvent(), new Date(subscribe.getTimestamp()), new Time(subscribe.getTimestamp())));
        // create an answer
        BasicMessageModel answer = new TextMessageModel(subscribe.getUser().getId(), TextMessageModel.TYPE, "Привет. Для получение задание нужно написать в сообщении имя задания. Например test34.py.");
        // save an answer
        this.repoAnswer.save(new Answer(subscribe.getUser().getId(), answer.getText()));
        // return json answer
        return this.gson.toJson(answer);
    }
    
    @Override
    public String getEventResponse(EventRequestModel message) throws IOException {
        BasicMessageModel answer = null;
        // find message with the token
        List<Question> dublicateQuestins = this.repoQuestion.findByToken(message.getMessage_token());
        // check dublicate message    
        if (dublicateQuestins.isEmpty()) {
            // save a question
            this.repoQuestion.save(new Question(message.getSender().getName(), message.getMessage_token(), message.getSender().getId(), message.getMessage().getText(), new Date(message.getTimestamp()), new Time(message.getTimestamp())));
            // create an answer
            message.getMessage().setText(message.getMessage().getText().toLowerCase());
            Matcher matcher = Pattern.compile("test[0-9]+.py").matcher(message.getMessage().getText());
            if (matcher.find()) {
                String task = message.getMessage().getText().substring(matcher.start(), matcher.end());
                Path path = Paths.get(new java.io.File(".").getCanonicalPath() + "/src/main/resources/public/" + task);
                if(Files.exists(path)) {
                    // file with a task
                    answer = new FileMessageModel(message.getSender().getId(), FileMessageModel.TYPE, this.domain + task, task, Files.size(path));
                } else {
                    // the task is not  ready
                    answer = new TextMessageModel(message.getSender().getId(), TextMessageModel.TYPE, "Задание еще не полностью готово");
                }
            } else {
                // a bot answer
                answer = this.botlibreManager.getResponse(message.getSender().getId(), message.getMessage().getText());
            }
            // save an answer
            this.repoAnswer.save(new Answer(message.getSender().getId(), answer.getText()));
            
            System.out.println("End "+answer.getText());
        } else {
            System.out.println("Dublicate message" + message.getMessage());
        }
     
        return this.gson.toJson(answer);
    }
    
    @Override
    public String getDefaultResponse() {
        return this.gson.toJson(new DefaultResponseModel());
    }
    
    @Override
    public String getErrorResponse(String error) {
        System.out.println(error);
        return this.gson.toJson(new ErrorResponseModel());
    }
    
    @Override
    public String getTypeEvent(String decoded) throws JsonProcessingException {
        System.out.println(decoded);
        JsonNode jsonNode = this.objectMapper.readTree(decoded);
        return jsonNode.get("event").asText();
    }
}
