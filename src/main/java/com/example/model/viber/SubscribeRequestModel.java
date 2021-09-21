package com.example.model.viber;

public class SubscribeRequestModel {
    protected String event;
    protected Long timestamp;
    protected String chat_hostname;
    protected Long message_token;
    protected User user;

    public SubscribeRequestModel(String event, Long timestamp, String chat_hostname, Long message_token, User user) {
        this.event = event;
        this.timestamp = timestamp;
        this.chat_hostname = chat_hostname;
        this.message_token = message_token;
        this.user = user;
    }

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

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
    
    public class User {
        protected String id;
        protected String name;
        protected String avatar;
        protected String language;
        protected String country;
        protected Integer api_version;

        public User(String id, String name, String avatar, String language, String country, Integer api_version) {
            this.id = id;
            this.name = name;
            this.avatar = avatar;
            this.language = language;
            this.country = country;
            this.api_version = api_version;
        }

        public String getId() {
            return id;
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
    }
}