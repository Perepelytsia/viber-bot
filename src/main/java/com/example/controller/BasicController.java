package com.example.controller;

import com.example.service.HttpClient;
import com.example.model.callback.response.Default;
import com.example.model.callback.response.Error;
import com.example.model.callback.response.Webhook;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.example.model.call.request.Text;
import com.example.model.callback.request.Message;
import java.net.URLDecoder;

@RestController
public class BasicController {

    @Autowired
    private Gson gson;
    
    @Autowired
    private ObjectMapper objectMapper;
    
    @PostMapping("/")
    public String applyEvent(@RequestBody String payload) throws JsonProcessingException, Exception {
        
        String decoded = URLDecoder.decode(payload, "UTF-8");
        System.out.println(decoded);
        try {
            JsonNode jsonNode = this.objectMapper.readTree(decoded);
            switch(jsonNode.get("event").asText()) {
                case "webhook":
                    System.out.println("request webhook");
                    return this.gson.toJson(new Webhook());
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
                    System.out.println("Start message");
                    Message message = this.gson.fromJson(decoded, Message.class);
                    
                    final String receiver = message.getSender().getId();
                    final Integer min_api_version = message.getSender().getApi_version();
                    final String name = "Alex Perepelytsia";
                    final String avatar = "https://media-direct.cdn.viber.com/download_photo?dlid=k9lPCdXcJ_2WK9hNEkPifKVFaC2MnIohSqvlsmcutq_UKO2xyYoj5qsm1SSZIC4WBCj2iEJXjuMd9oU4t1GyFhvPwXEkDrsHOE6AAFQEFlKNFa_crUHqP1pllxyey9RqCPShnA&fltp=jpg&imsz=0000";
                               
                    Thread newThread = new Thread(() -> {
                        System.out.println("Start Thread");
                        HttpClient client = new HttpClient();

                        Text model = new Text(receiver, min_api_version, name, avatar, "test", "text", "Hello world!!!");

                        client.sendPost(this.gson.toJson(model));
                        System.out.println("End Thread");
                    });
                    newThread.start();

                    System.out.println("End message");;
                    break;
            }
            return this.gson.toJson(new Default());
           
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return this.gson.toJson(new Error());
        }
        
    }
}
