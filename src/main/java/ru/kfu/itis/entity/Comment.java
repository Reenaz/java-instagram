package ru.kfu.itis.entity;

import java.sql.Date;


public class Comment {
    private int id;
    private int postId;
    private int userId;
    private String text;
    private Date date;

    public Comment() {
    }

    public Comment(int postId, int userId, String text, Date date) {
        this.postId = postId;
        this.userId = userId;
        this.text = text;
        this.date = date;
    }

    public Comment(int id, int postId, int userId, String text, Date date) {
        this.id = id;
        this.postId = postId;
        this.userId = userId;
        this.text = text;
        this.date = date;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPostId() {
        return postId;
    }

    public void setPostId(int postId) {
        this.postId = postId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
