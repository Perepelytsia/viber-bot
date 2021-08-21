package com.example;

import com.google.gson.Gson;
import java.util.HashMap;
import java.util.Map;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import com.google.common.base.Charsets;
import com.google.common.io.CharSink;
import com.google.common.io.FileWriteMode;
import com.google.common.io.Files;
import java.io.File;
import java.io.IOException;

@RestController
public class HomeController {
    
    
    @Autowired
    private Gson gson;
 
    
    @PostMapping("/")
    public Map<String, String> getPost(@RequestBody String payload) {
        
        System.out.println(payload);

        try {
           String fileName = "src/main/resources/request.log";
        File file = new File(fileName);
        CharSink chs = Files.asCharSink(file, Charsets.UTF_8, FileWriteMode.APPEND);
        chs.write(payload+"\n");
        } catch (IOException e) {
            e.printStackTrace();
        }
        
        
        Map<String, String> map = new HashMap<String, String>();
        map.put("result", "success");
        
        return map;
    }
}
