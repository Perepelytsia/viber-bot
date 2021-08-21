package com.example;

import com.google.gson.Gson;
import java.util.HashMap;
import java.util.Map;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
public class HomeController {
    
    
    @Autowired
    private Gson gson;
 
    
    @PostMapping("/")
    public Map<String, String> getPost(@RequestBody String payload) {
        
        System.out.println(payload);

        String fileName = "src/main/resources/request.log";
        
        
        Map<String, String> map = new HashMap<String, String>();
        map.put("result", "success");
        
        return map;
    }
}
