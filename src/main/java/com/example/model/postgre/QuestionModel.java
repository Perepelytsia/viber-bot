package com.example.model.postgre;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.sql.Date;
import java.sql.Time;
import java.sql.Timestamp;

@Entity
public class QuestionModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected Long id;
    protected String name;
    protected String data;
    protected String uid;
    protected Long token;
    protected Date day;
    protected Time at;
    
    public QuestionModel() {  
    }

    public QuestionModel(String name, Long token, String uid, String data, Date day, Time at) {
        this.name = name;
        this.token = token;
        this.uid = uid;
        this.data = data;
        this.day = day;
        this.at = at;
    }
    
    public QuestionModel(String name, Long token, String uid, String data) {
        this.name = name;
        this.token = token;
        this.uid = uid;
        this.data = data;
        
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        
        this.day = new Date(timestamp.getTime());
        this.at = new Time(timestamp.getTime());
    }

    public Long getToken() {
        return token;
    }

    public void setToken(long token) {
        this.token = token;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public Date getDay() {
        return day;
    }

    public void setDay(Date day) {
        this.day = day;
    }

    public Time getAd() {
        return at;
    }

    public void setAd(Time at) {
        this.at = at;
    }
}