package com.example;

import com.google.gson.Gson;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import com.example.WebhookResponseModel;

@RestController
public class HomeController {
    
    
    @Autowired
    private Gson gson;
 
    
    @PostMapping("/")
    public String applyPost(@RequestBody String payload) {
        
        System.out.println(payload);
        
        String[] event_types = {
            "delivered",
            "seen",
            "failed",
            "subscribed",
            "unsubscribed",
            "conversation_started"
        };
        WebhookResponseModel webhookResponseModel = new WebhookResponseModel("ok", 0, event_types);
        
        return this.gson.toJson(webhookResponseModel);
    }
}
