package com.example.service;

import com.example.model.viber.TextMessageModel;

public interface BotlibreService {
    public abstract TextMessageModel getResponse(String id, String question);
}
