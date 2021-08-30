package com.example.model.callback.request;

public class Event {
    private String event;
    private Long timestamp;
    private String chat_hostname;
    private Long message_token;
    private boolean silent;
    private Sender sender;
    private Message message;

    public String getEvent() {
        return event;
    }

    public void setEvent(String event) {
        this.event = event;
    }

    public Long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Long timestamp) {
        this.timestamp = timestamp;
    }

    public String getChat_hostname() {
        return chat_hostname;
    }

    public void setChat_hostname(String chat_hostname) {
        this.chat_hostname = chat_hostname;
    }

    public Long getMessage_token() {
        return message_token;
    }

    public void setMessage_token(Long message_token) {
        this.message_token = message_token;
    }

    public boolean isSilent() {
        return silent;
    }

    public void setSilent(boolean silent) {
        this.silent = silent;
    }

    public Sender getSender() {
        return sender;
    }

    public void setSender(Sender sender) {
        this.sender = sender;
    }

    public Message getMessage() {
        return this.message;
    }

    @Override
    public String toString() {
        return "Message{" + "event=" + event + ", timestamp=" + timestamp + ", chat_hostname=" + chat_hostname + ", message_token=" + message_token + ", silent=" + silent + ", sender=" + sender + ", text=" + message + '}';
    }

    public void setMessage(Message message) {
        this.message = message;
    }

    public Event(String event, Long timestamp, String chat_hostname, Long message_token, boolean silent, Sender sender, Message message) {
        this.event = event;
        this.timestamp = timestamp;
        this.chat_hostname = chat_hostname;
        this.message_token = message_token;
        this.silent = silent;
        this.sender = sender;
        this.message = message;
    }

    public class Sender {
        private String id;
        private String name;
        private String avatar;
        private String country;
        private Integer api_version;

        public String getId() {
            return id;
        }

        @Override
        public String toString() {
            return "Sender{" + "id=" + id + ", name=" + name + ", avatar=" + avatar + ", language=" + language + ", country=" + country + ", api_version=" + api_version + '}';
        }

        public void setId(String id) {
            this.id = id;
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

        public String getLanguage() {
            return language;
        }

        public void setLanguage(String language) {
            this.language = language;
        }

        public String getCountry() {
            return country;
        }

        public void setCountry(String country) {
            this.country = country;
        }

        public Integer getApi_version() {
            return api_version;
        }

        public void setApi_version(Integer api_version) {
            this.api_version = api_version;
        }
        private String language;

        public Sender(String id) {
            this.id = id;
        }
    }
    
    public class Message {
        private String text;
        private String type;

        public String getText() {
            return text;
        }

        @Override
        public String toString() {
            return "Text{" + "text=" + text + ", type=" + type + '}';
        }

        public void setText(String text) {
            this.text = text;
        }

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

        public Message(String text, String type) {
            this.text = text;
            this.type = type;
        }
    }
}