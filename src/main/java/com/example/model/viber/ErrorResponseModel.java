package com.example.model.viber;

public class ErrorResponseModel extends BasicResponseModel {
    public ErrorResponseModel() {
        this.status_message = "error";
        this.status = 13;
    } 
}
