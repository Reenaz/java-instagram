package ru.kfu.itis.entity;

import java.sql.Blob;

/**
 * Created by Reenaz on 13.11.2017.
 */
public class Post {
    private int id;
    private int userId;
    private Blob photo;
    private String description;
    private String location;

    public Post() {
    }

    public Post(int userId, Blob photo, String description, String location) {
        this.userId = userId;
        this.photo = photo;
        this.description = description;
        this.location = location;
    }

    public Post(int id, int userId, Blob photo, String description, String location) {
        this.id = id;
        this.userId = userId;
        this.photo = photo;
        this.description = description;
        this.location = location;
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

    public Blob getPhoto() {
        return photo;
    }

    public void setPhoto(Blob photo) {
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
}
