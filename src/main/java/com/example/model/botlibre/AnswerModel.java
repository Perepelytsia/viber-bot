package com.example.model.botlibre;

public class AnswerModel {
    protected Long conversation;
    protected String emote;
    protected String avatar;
    protected String avatarType;
    protected String avatarTalk;
    protected String avatarTalkType;
    protected String avatarBackground;
    protected String message;

    public AnswerModel(Long conversation, String emote, String avatar, String avatarType, String avatarTalk, String avatarTalkType, String avatarBackground, String message) {
        this.conversation = conversation;
        this.emote = emote;
        this.avatar = avatar;
        this.avatarType = avatarType;
        this.avatarTalk = avatarTalk;
        this.avatarTalkType = avatarTalkType;
        this.avatarBackground = avatarBackground;
        this.message = message;
    }

    public Long getConversation() {
        return conversation;
    }

    public void setConversation(Long conversation) {
        this.conversation = conversation;
    }

    public String getEmote() {
        return emote;
    }

    public void setEmote(String emote) {
        this.emote = emote;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public String getAvatarType() {
        return avatarType;
    }

    public void setAvatarType(String avatarType) {
        this.avatarType = avatarType;
    }

    public String getAvatarTalk() {
        return avatarTalk;
    }

    public void setAvatarTalk(String avatarTalk) {
        this.avatarTalk = avatarTalk;
    }

    public String getAvatarTalkType() {
        return avatarTalkType;
    }

    public void setAvatarTalkType(String avatarTalkType) {
        this.avatarTalkType = avatarTalkType;
    }

    public String getAvatarBackground() {
        return avatarBackground;
    }

    public void setAvatarBackground(String avatarBackground) {
        this.avatarBackground = avatarBackground;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
