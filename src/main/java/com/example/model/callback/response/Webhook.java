package com.example.model.callback.response;

public class Webhook extends Basic {
    
    protected String[] event_types;

    public void setEvent_types(String[] event_types) {
        this.event_types = event_types;
    }

    public String[] getEvent_types() {
        return event_types;
    }

    public Webhook() {
        this.status_message = "ok";
        this.status = 0;
        String[] event_types = {"message", "delivered", "seen", "failed", "subscribed", "unsubscribed", "conversation_started"};
        this.event_types = event_types;
    }
    
}
