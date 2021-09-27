package com.example.service;

import com.example.model.postgre.Answer;
import com.example.model.postgre.Question;
import com.example.repository.AnswerRepository;
import com.example.repository.QuestionRepository;
import com.google.gson.Gson;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.model.admin.UserModel;
import com.example.model.admin.ChatModel;

@Service
public class ChatServiceImpl implements ChatService {
    
    @Autowired
    protected AnswerRepository repoAnswer;
    
    @Autowired
    protected QuestionRepository repoQuestion;
    
    @Autowired
    protected Gson gson;
    
    @Override
    public String getUsers() {
        List<UserModel> users = this.repoQuestion.groupAndCountByName();
         /*try {
            UserModel q = users.get(0);
            System.out.println(URLEncoder.encode(q.getUid(), "UTF-8"));
         } catch (Exception e) {
            System.out.println(e.getMessage());
         }*/
        return this.gson.toJson(users);
    }
    
    // Spring Data JPA Projections
    @Override
    public String getUsers2() {
        List users = this.repoQuestion.groupAndCountByName2();
        return this.gson.toJson(users);
    }
    
    @Override
    public String getChat(String uid) {
        List<Question> questions = this.repoQuestion.findByUid(uid);
        List<Answer> answers = this.repoAnswer.findByUid(uid);
        ChatModel chat = new ChatModel(answers, questions);
        return this.gson.toJson(chat);
    }
}
