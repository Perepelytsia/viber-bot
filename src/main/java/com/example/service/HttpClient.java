package com.example.service;

import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import java.io.IOException;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.entity.StringEntity;
import org.springframework.beans.factory.annotation.Value;

public class HttpClient {
    
    @Value("${token}")
    private String token;
    
    protected void sendPost(String answer) {
        try {
            System.out.println("Send Http POST request");
            
            CloseableHttpClient httpClient = HttpClients.createDefault();
            HttpPost post = new HttpPost("https://chatapi.viber.com/pa/send_message");

            String json = answer;
            StringEntity entity = new StringEntity(json);
            post.setEntity(entity);
            post.setHeader("X-Viber-Auth-Token", this.token);
            post.setHeader("Accept", "application/json");
            post.setHeader("Content-type", "application/json");
            
            CloseableHttpResponse response = httpClient.execute(post);
            
            System.out.println(response.getStatusLine().getStatusCode());    
        } catch (ClientProtocolException e) {
            System.out.println(e.getMessage());
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
    
    public void createThread(String answer)
    {
        Thread newThread = new Thread(() -> {
            System.out.println("Start Thread");
            HttpClient client = new HttpClient();
            client.sendPost(answer);
            System.out.println("End Thread");
        });
        newThread.start();
    }
}
