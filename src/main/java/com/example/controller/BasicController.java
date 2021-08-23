package com.example.controller;

import com.example.model.DefaultResponseModel;
import com.example.model.ErrorResponseModel;
import com.example.model.WebhookResponseModel;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class BasicController {

    @Autowired
    private Gson gson;
    
    @Autowired
    private ObjectMapper objectMapper;
 
    @PostMapping("/")
    public String applyEvent(@RequestBody String payload) throws JsonProcessingException, Exception {
        
        System.out.println(payload);
        try {
            JsonNode jsonNode = this.objectMapper.readTree(payload);
            switch(jsonNode.get("event").asText()) {
                case "webhook":
                    System.out.println("here");
                    return this.gson.toJson(new WebhookResponseModel());
                case "seen":
                    // code
                    break;
                case "delivered":
                    // code
                    break; 
                case "failed":
                    // code
                    break;
                case "subscribed":
                    // code
                    break;
                case "unsubscribed":
                    // code
                    break;
                case "message":
                    // code
                    break;
            }
            return this.gson.toJson(new DefaultResponseModel());
           
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return this.gson.toJson(new ErrorResponseModel());
        }
    }
}
