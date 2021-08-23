package com.example.model;

public class ErrorResponseModel extends ResponseModel {
    public ErrorResponseModel() {
        this.status_message = "error";
        this.status = 13;
    } 
}
