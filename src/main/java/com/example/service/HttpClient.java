package com.example.service;

import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import java.io.IOException;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.entity.StringEntity;

public class HttpClient {
    public void sendPost(String data) {
        try {
            System.out.println("Send Http POST request");
            
            CloseableHttpClient httpClient = HttpClients.createDefault();
            HttpPost post = new HttpPost("https://chatapi.viber.com/pa/send_message");

            String json = data;
            StringEntity entity = new StringEntity(json);
            post.setEntity(entity);
            post.setHeader("X-Viber-Auth-Token", "4de736e4df27d5ba-2064c41ce6fdb782-1df314ba68cd291");
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
}
