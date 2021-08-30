package com.example.model.call.request;

public abstract class Basic {
    protected String receiver;
    protected Integer min_api_version;
    protected Sender sender;
    protected String tracking_data;
    protected String type;

    public Basic(String receiver, String type) {
        this.receiver = receiver;
        this.min_api_version = 2;
        this.sender = new Sender("Alex Perepelytsia", "https://media-direct.cdn.viber.com/download_photo?dlid=k9lPCdXcJ_2WK9hNEkPifKVFaC2MnIohSqvlsmcutq_UKO2xyYoj5qsm1SSZIC4WBCj2iEJXjuMd9oU4t1GyFhvPwXEkDrsHOE6AAFQEFlKNFa_crUHqP1pllxyey9RqCPShnA&fltp=jpg&imsz=0000");
        this.tracking_data = "test";
        this.type = type;
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

    public class Sender {
        protected String name;
        protected String avatar;

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
