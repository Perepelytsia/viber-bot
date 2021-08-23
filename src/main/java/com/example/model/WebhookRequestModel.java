package com.example.model;

public class WebhookRequestModel {
    private String event;
    private Integer timestamp;
    private String status_message;
    private Integer status;

    public String getEvent() {
        return event;
    }

    public void setEvent(String event) {
        this.event = event;
    }

    public Integer getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Integer timestamp) {
        this.timestamp = timestamp;
    }

    public String getStatus_message() {
        return status_message;
    }

    public void setStatus_message(String status_message) {
        this.status_message = status_message;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public WebhookRequestModel(String event, Integer timestamp, String status_message, Integer status) {
        this.event = event;
        this.timestamp = timestamp;
        this.status_message = status_message;
        this.status = status;
    }
}
