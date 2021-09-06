package com.example.model.postgre;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.sql.Date;
import java.sql.Time;
import java.sql.Timestamp;

@Entity
public class Answer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected Long id;
    protected String token;
    protected String data;
    protected Date day;
    protected Time at;

    public Answer(String token, String data, Date day, Time at) {
        this.token = token;
        this.data = data;
        this.day = day;
        this.at = at;
    }
    
    public Answer(String token, String data) {
        this.token = token;
        this.data = data;
        
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        
        this.day = new Date(timestamp.getTime());
        this.at = new Time(timestamp.getTime());
    }
    
    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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