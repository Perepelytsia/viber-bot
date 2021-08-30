package com.example.model.call.request;

public class Text extends Basic {
    protected String text;

    public Text(String receiver, String type, String text) {
        super(receiver, type);
        this.text = text;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
