package com.example.model;

public abstract class ResponseModel {
    
    protected String status_message;
    protected Integer status;

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
}
