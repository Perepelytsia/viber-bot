package com.example.model.call.request;

public class Text {
    private String receiver;
    private Integer min_api_version;
    private Sender sender;
    private String tracking_data;
    private String type;
    private String text;

    public Text(String receiver, Integer min_api_version, String name, String avatar, String tracking_data, String type, String text) {
        this.receiver = receiver;
        this.min_api_version = min_api_version;
        this.sender = new Sender(name, avatar);
        this.tracking_data = tracking_data;
        this.type = type;
        this.text = text;
    }

    public String getReceiver() {
        return receiver;
    }

    public void setReceiver(String receiver) {
        this.receiver = receiver;
    }

    public Integer getMin_api_version() {
        return min_api_version;
    }

    public void setMin_api_version(Integer min_api_version) {
        this.min_api_version = min_api_version;
    }

    public Sender getSender() {
        return sender;
    }

    public void setSender(Sender sender) {
        this.sender = sender;
    }

    public String getTracking_data() {
        return tracking_data;
    }

    public void setTracking_data(String tracking_data) {
        this.tracking_data = tracking_data;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
    
    public class Sender {
        private String name;
        private String avatar;

        public Sender(String name, String avatar) {
            this.name = name;
            this.avatar = avatar;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getAvatar() {
            return avatar;
        }

        public void setAvatar(String avatar) {
            this.avatar = avatar;
        }
    }
}
