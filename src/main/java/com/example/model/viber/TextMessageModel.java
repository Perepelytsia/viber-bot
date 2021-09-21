package com.example.model.viber;

public class TextMessageModel extends BasicMessageModel {
    public static final String TYPE="text";
    protected String text;

    public TextMessageModel(String receiver, String type, String text) {
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
