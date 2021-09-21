package com.example.model.botlibre;

public class QuestionModel {
    protected Long application;
    protected int instance;
    protected String message;

    public QuestionModel(Long application, int instance, String message) {
        this.application = application;
        this.instance = instance;
        this.message = message;
    }

    public Long getApplication() {
        return application;
    }

    public void setApplication(Long application) {
        this.application = application;
    }

    public int getInstance() {
        return instance;
    }

    public void setInstance(int instance) {
        this.instance = instance;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
