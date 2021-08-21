/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example;

/**
 *
 * @author sith
 */
public class WebhookResponseModel {
    private String status_message;
    private Integer status;
    private String[] event_types;

    public void setEvent_types(String[] event_types) {
        this.event_types = event_types;
    }

    public String[] getEvent_types() {
        return event_types;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public void setStatus_message(String status_message) {
        this.status_message = status_message;
    }

    public Integer getStatus() {
        return this.status;
    }

    public String getStatus_message() {
        return this.status_message;
    }

    public WebhookResponseModel(String status_message, Integer status, String[] event_types) {
        this.status_message = status_message;
        this.status = status;
        this.event_types = event_types;
    }
}


