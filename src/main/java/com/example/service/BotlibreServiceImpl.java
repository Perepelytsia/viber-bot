package com.example.service;

import com.example.model.viber.TextMessageModel;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.model.botlibre.AnswerModel;

@Service
public class BotlibreServiceImpl implements BotlibreService {
    
    @Autowired
    protected HttpClientService httpManager;
    
    @Autowired
    protected Gson gson;
    
    @Override
    public TextMessageModel getResponse(String id, String question) {
        String answerJson = this.httpManager.send2Botlibre(question);
        System.out.println(answerJson);
        AnswerModel answerObj = this.gson.fromJson(answerJson, com.example.model.botlibre.AnswerModel.class);
        return new TextMessageModel(id, TextMessageModel.TYPE, answerObj.getMessage());
    }
    
}
