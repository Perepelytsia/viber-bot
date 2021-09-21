package com.example.service;

import com.google.gson.Gson;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import java.io.IOException;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.entity.StringEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import com.example.model.botlibre.QuestionModel;
import org.apache.http.util.EntityUtils;

@Service
public class HttpClientServiceImpl implements HttpClientService {
    
    @Autowired
    protected Gson gson;
    
    @Value("${botlibre.url}")
    protected String url;
    
    @Value("${botlibre.app}")
    protected Long app;
    
    @Value("${botlibre.bot}")
    protected int bot;
    
    @Value("${viber.token}")
    protected String token;
    
    @Value("${viber.url}")
    protected String target;
    
    protected String botAnswer;
    
    @Override
    public void send2Viber(String answer) {
        Thread thread = new Thread(() -> {
            try {
                System.out.println("Send message 2 Viber");
                CloseableHttpClient httpClient = HttpClients.createDefault();
                System.out.println(this.target);
                HttpPost post = new HttpPost(this.target);
                StringEntity entity = new StringEntity(answer, "UTF-8");
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
        });
        thread.start();
    }
    
    @Override
    public String send2Botlibre(String question) {
        try {
            Thread thread = new Thread(() -> {
                try {
                    System.out.println("Send message 2 Botlibre");
                    CloseableHttpClient httpClient = HttpClients.createDefault();
                    System.out.println(this.url);
                    HttpPost post = new HttpPost(this.url);
                    StringEntity entity = new StringEntity(this.gson.toJson(new QuestionModel(this.app, this.bot, question)), "UTF-8");
                    post.setEntity(entity);
                    post.setHeader("Accept", "application/json");
                    post.setHeader("Content-type", "application/json");
                    CloseableHttpResponse response = httpClient.execute(post);
                    this.botAnswer = EntityUtils.toString(response.getEntity());
                    System.out.println(response.getStatusLine().getStatusCode());
                } catch (ClientProtocolException e) {
                    System.out.println(e.getMessage());
                } catch (IOException e) {
                    System.out.println(e.getMessage());
                }
            });
            thread.start();
            thread.join();
            
        } catch (InterruptedException e) {
            System.out.println(e.getMessage());
        }
        
        return this.botAnswer;
    }
}
