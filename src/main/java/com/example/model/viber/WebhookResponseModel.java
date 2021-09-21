package com.example.model.viber;

public class WebhookResponseModel extends BasicResponseModel {
    
    protected String[] event_types;

    public void setEvent_types(String[] event_types) {
        this.event_types = event_types;
    }

    public String[] getEvent_types() {
        return event_types;
    }

    public WebhookResponseModel() {
        this.status_message = "ok";
        this.status = 0;
        String[] event_types = {"message", "delivered", "seen", "failed", "subscribed", "unsubscribed", "conversation_started"};
        this.event_types = event_types;
    }
    
}
