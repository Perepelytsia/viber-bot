package com.example.model.admin;

public class UserModel {
    protected String name;
    protected String uid;
    protected Long messages;

    public UserModel(String name, String uid, Long messages) {
        this.name = name;
        this.uid = uid;
        this.messages = messages;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public Long getMessages() {
        return messages;
    }

    public void setMessages(Long messages) {
        this.messages = messages;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}