package com.example.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import com.example.service.HttpClientService;
import com.example.service.ViberService;
import java.net.URLDecoder;

@RestController
public class EventController {
    
    @Autowired
    protected HttpClientService httpManager;
    
    @Autowired
    protected ViberService viberManager;
    
    @PostMapping("/")
    public String applyEvent(@RequestBody String payload) throws Exception {
        String decoded = URLDecoder.decode(payload, "UTF-8");
        try {
            switch(this.viberManager.getTypeEvent(decoded)) {
                case "webhook":
                    return this.viberManager.getWebhookResponse();
                case "seen":
                    break;
                case "delivered":
                    break; 
                case "failed":
                    break;
                case "subscribed":
                    this.httpManager.send2Viber(
                            this.viberManager.getSubscribeResponse(
                                    this.viberManager.getSubscribeRequest(decoded)
                            )
                    );
                    break;
                case "unsubscribed":
                     break;
                case "message":
                     this.httpManager.send2Viber(
                            this.viberManager.getEventResponse(
                                    this.viberManager.getEventRequest(decoded)
                            )
                    );
                    break;
            }       
            return this.viberManager.getDefaultResponse();
        } catch (Exception e) {
            return this.viberManager.getErrorResponse(e.getMessage());
        }
    }
}