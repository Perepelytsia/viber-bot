package com.example.service;

import com.example.model.viber.EventRequestModel;
import com.example.model.viber.SubscribeRequestModel;
import com.fasterxml.jackson.core.JsonProcessingException;
import java.io.IOException;

public interface ViberService {
    public abstract SubscribeRequestModel getSubscribeRequest(String incomeEvent);
    public abstract EventRequestModel getEventRequest(String incomeEvent);
    public abstract String getWebhookResponse();
    public abstract String getSubscribeResponse(SubscribeRequestModel subscribe);
    public abstract String getEventResponse(EventRequestModel message) throws IOException;
    public abstract String getDefaultResponse();
    public abstract String getErrorResponse(String error);
    public abstract String getTypeEvent(String decode) throws JsonProcessingException;
}
