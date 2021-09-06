package com.example.controller;

import com.example.model.call.request.Basic;
import com.example.model.call.request.File;
import com.example.model.call.request.Text;
import com.example.model.callback.response.Default;
import com.example.model.callback.response.Error;
import com.example.model.callback.response.Webhook;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.example.model.callback.request.Event;
import com.example.model.callback.request.Subscribe;
import com.example.service.HttpClient;
import java.net.URLDecoder;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.beans.factory.annotation.Autowired;
import java.sql.Date;
import java.sql.Time;
import com.example.model.postgre.Question;
import com.example.model.postgre.Answer;
import com.example.repository.AnswerRepository;
import com.example.repository.QuestionRepository;

@RestController
public class EventController {
    
    @Value("${domain}")
    protected String domain;
    
    @Autowired
    protected HttpClient clientMessage;
            
    @Autowired
    protected AnswerRepository repoAnswer;
    
    @Autowired
    protected QuestionRepository repoQuestion;

    @Autowired
    protected Gson gson;
    
    @Autowired
    protected ObjectMapper objectMapper;
    
    protected String receiver;
    
    protected String msg;
    
    protected Basic answer;
    
    @PostMapping("/")
    public String applyEvent(@RequestBody String payload) throws JsonProcessingException, Exception {
        
        String decoded = URLDecoder.decode(payload, "UTF-8");
        System.out.println(decoded);
        try {
            JsonNode jsonNode = this.objectMapper.readTree(decoded);
            System.out.println(jsonNode.get("event").asText());
            switch(jsonNode.get("event").asText()) {
                case "webhook":
                    return this.gson.toJson(new Webhook());
                case "seen":
                    break;
                case "delivered":
                    break; 
                case "failed":
                    break;
                case "subscribed":
                     // parse a question
                     Subscribe subscribe = this.gson.fromJson(decoded, Subscribe.class);
                     // save a question
                     this.repoQuestion.save(new Question(subscribe.getUser().getName(), subscribe.getUser().getId(), jsonNode.get("event").asText(), new Date(subscribe.getTimestamp()), new Time(subscribe.getTimestamp())));
                     // create an answer
                     this.answer = new Text(subscribe.getUser().getId(), Text.TYPE, "Привет. Для получение задание нужно написать в сообщении имя задания. Например test34.py.");
                     // save an answer
                     this.repoAnswer.save(new Answer(subscribe.getUser().getId(), this.answer.getText()));
                     // send an answer
                     this.clientMessage.createThread(this.gson.toJson(this.answer));
                     System.out.println("End "+jsonNode.get("event").asText());
                    break;
                case "unsubscribed":
                    break;
                case "message":
                    // parse a question
                    Event message = this.gson.fromJson(decoded, Event.class);
                    // save a question
                    this.repoQuestion.save(new Question(message.getSender().getName(), message.getSender().getId(), message.getMessage().getText(), new Date(message.getTimestamp()), new Time(message.getTimestamp())));
                    // create an answer                
                    Matcher matcher = Pattern.compile("test[0-9]+.py").matcher(message.getMessage().getText());
                    if (matcher.find()) {
                        String task = message.getMessage().getText().substring(matcher.start(), matcher.end());
                        Path path = Paths.get(new java.io.File(".").getCanonicalPath() + "/src/main/resources/static/" + task);
                        if(Files.exists(path)) {
                            this.answer = new File(message.getSender().getId(), File.TYPE, this.domain + task, task, Files.size(path));
                        } else {
                            this.answer = new Text(message.getSender().getId(), Text.TYPE, "Задание еще не полностью готово");
                        }
                    } else {
                        this.answer = new Text(message.getSender().getId(), Text.TYPE, "API ответ");
                    }
                    // save an answer
                    this.repoAnswer.save(new Answer(message.getSender().getId(), this.answer.getText()));
                    // send an answer
                    clientMessage.createThread(this.gson.toJson(this.answer));
                    System.out.println("End "+jsonNode.get("event").asText());
                    break;
            }
            return this.gson.toJson(new Default());
           
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return this.gson.toJson(new Error());
        }
        
    }
}
