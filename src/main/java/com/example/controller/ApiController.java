package com.example.controller;

import com.example.service.ChatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@RestController
@CrossOrigin
public class ApiController {
    
    @Autowired
    protected ChatService chatService;
    
    @GetMapping("/api/users")
    public String getUsers() {
        return this.chatService.getUsers();
    }
    
    @GetMapping("/api/chat")
    public String getChat(@RequestParam String uid) {
        return this.chatService.getChat(uid);
    }
}
