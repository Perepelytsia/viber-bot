package com.example;

import java.io.File;
import com.google.gson.Gson;
import java.io.FileWriter;
import java.util.HashMap;
import java.util.Map;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

@RestController
public class HomeController {
    
    
    @Autowired
    private Gson gson;
 
    
    @PostMapping("/")
    public Map<String, String> getPost(@RequestBody String payload) {
        
        System.out.println(payload);

        String fileName = "src/main/resources/request.log";
        try {
            Files.writeString(Paths.get(fileName), payload, StandardCharsets.UTF_8, StandardOpenOption.APPEND);
        } catch (IOException e) {
            e.printStackTrace();
        }
        
        Map<String, String> map = new HashMap<String, String>();
        map.put("result", "success");
        
        return map;
    }
}
