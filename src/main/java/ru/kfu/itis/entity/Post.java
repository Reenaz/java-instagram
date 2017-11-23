package ru.kfu.itis.entity;

import java.sql.Blob;
import java.sql.Date;

/**
 * Created by Reenaz on 13.11.2017.
 */
public class Post {
    private int id;
    private int userId;
    private String photo;
    private String description;
    private String location;
    private Date date;

    public Post() {
    }

    public Post(int userId, String photo, String description, String location, Date date) {
        this.userId = userId;
        this.photo = photo;
        this.description = description;
        this.location = location;
        this.date = date;
    }

    public Post(int id, int userId, String photo, String description, String location, Date date) {
        this.id = id;
        this.userId = userId;
        this.photo = photo;
        this.description = description;
        this.location = location;
        this.date = date;
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
}
