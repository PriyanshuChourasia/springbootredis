package com.redis.springbootredis.entities;

import java.io.Serializable;
import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="stream_note")
public class Note implements  Serializable{

    @Id
    private String id;

    private String title;

    private String content;

    private Date createdAt = new Date();

    private Date updatedAt = new Date();

    private boolean live = false;

    public Note(String content, Date createdAt, String id, String title, Date updatedAt) {
        this.content = content;
        this.createdAt = createdAt;
        this.id = id;
        this.title = title;
        this.updatedAt = updatedAt;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }

    public boolean isLive() {
        return live;
    }

    public void setLive(boolean live) {
        this.live = live;
    }

    public Note(){
        
    }
    
}
