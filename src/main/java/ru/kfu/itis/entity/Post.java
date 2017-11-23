package ru.kfu.itis.entity;

import java.sql.Blob;
import java.sql.Date;
import java.util.List;

public class Post {
    private int id;
    private int userId;
    private String photo;
    private String description;
    private String location;
    private Date date;
    public int likesCount;
    private List<Comment> comments;

    public Post() {
    }

    public Post(int id, int userId, String photo, String description, String location, Date date, int likesCount) {
        this.id = id;
        this.userId = userId;
        this.photo = photo;
        this.description = description;
        this.location = location;
        this.date = date;
        this.likesCount = likesCount;
    }

    public Post(int id, int userId, String photo, String description, String location, Date date, int likesCount, List<Comment> comments) {
        this.id = id;
        this.userId = userId;
        this.photo = photo;
        this.description = description;
        this.location = location;
        this.date = date;
        this.likesCount = likesCount;
        this.comments = comments;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public int getLikesCount() {
        return likesCount;
    }

    public void setLikesCount(int likesCount) {
        this.likesCount = likesCount;
    }

    public List<Comment> getComments() {
        return comments;
    }

    public void setComments(List<Comment> comments) {
        this.comments = comments;
    }

    public Post(int userId, String photo, String description, String location, Date date, int likesCount) {
        this.userId = userId;
        this.photo = photo;
        this.description = description;
        this.location = location;
        this.date = date;
        this.likesCount = likesCount;


    }
}
