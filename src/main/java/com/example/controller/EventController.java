package com.example.controller;

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

@RestController
public class EventController {
    
    @Value("${domain}")
    private String domain;

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
            String receiver = "";
            String msg = "default";
            Text textEvent;
            Thread newThread;
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
                     System.out.println("Start subscribed");
                     // data parse
                     Subscribe subscribe = this.gson.fromJson(decoded, Subscribe.class);
                     receiver = subscribe.getUser().getId();
                     textEvent = new Text(receiver, "text", "Привет. Для получение задание нужно написать в сообщении имя задания. Например test34.py.");
                     final String answer = this.gson.toJson(textEvent);
                    
                     // message thread
                     newThread = new Thread(() -> {
                        System.out.println("Start Thread");
                        HttpClient client = new HttpClient();
                        client.sendPost(answer);
                        System.out.println("End Thread");
                     });
                     newThread.start();
                     
                     System.out.println("End subscribed");
                    break;
                case "unsubscribed":
                    // code
                    break;
                case "message":
                    System.out.println("Start message");
                    
                    // data parse
                    Event message = this.gson.fromJson(decoded, Event.class);
                    receiver = message.getSender().getId();
              
                    String regex = "test[0-9]+.py";
                    Pattern pattern = Pattern.compile(regex);
                    String data = message.getMessage().getText();
                    Matcher matcher = pattern.matcher(data);
                    
                    if (matcher.find()) {
                        String task = data.substring(matcher.start(), matcher.end());
                        String currentPath = new java.io.File(".").getCanonicalPath();
                        Path path = Paths.get(currentPath + "/src/main/resources/static/" + task);
                        
                        // find file
                        if(Files.exists(path)) { 
                            File fileEvent = new File(receiver, "file", this.domain + task, task, Files.size(path));
                            msg = this.gson.toJson(fileEvent);
                        } else {
                            textEvent = new Text(receiver, "text", "Задание еще не полностью готово");
                            msg = this.gson.toJson(textEvent);
                        }
                    } else {
                        textEvent = new Text(receiver, "text", "API ответ");
                        msg = this.gson.toJson(textEvent);
                    }
                    
                    final String remessage = msg;
                    
                    // message thread
                    newThread = new Thread(() -> {
                        System.out.println("Start Thread");
                        HttpClient client = new HttpClient();
                        client.sendPost(remessage);
                        System.out.println("End Thread");
                    });
                    newThread.start();
    
                    System.out.println("End message");
                    break;
            }
            return this.gson.toJson(new Default());
           
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return this.gson.toJson(new Error());
        }
        
    }
}
