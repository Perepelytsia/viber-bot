package com.example.controller;

import com.example.model.viber.DefaultResponseModel;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@RestController
public class ApiController {
    
    @Autowired
    protected Gson gson;
    
    @GetMapping("/api")
    public String getApi(Model model) {
        return this.gson.toJson(new DefaultResponseModel());
    }
}
