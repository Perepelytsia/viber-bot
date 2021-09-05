package com.example.model.call.request;

public class Text extends Basic {
    public static final String TYPE="text";
    protected String text;

    public Text(String receiver, String type, String text) {
        super(receiver, type);
        this.text = text;
    }

    @Override
    public String getText() {
        return text;
    }

    @Override
    public void setText(String text) {
        this.text = text;
    }
}
