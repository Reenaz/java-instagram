package ru.kfu.itis.entity;

import java.sql.Blob;

/**
 * Created by Reenaz on 13.11.2017.
 */
public class User {
    private int id;
    private String userName;
    private String email;
    private String password;
    private String description;
    private String name;
    private String phoneNumber;
    private int gender;
    private int type;
    private Blob photo;

    public User() {
    }

    public User(String userName, String email, String password, String description, String name, String phoneNumber, int gender, int type, Blob photo) {
        this.userName = userName;
        this.email = email;
        this.password = password;
        this.description = description;
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.gender = gender;
        this.type = type;
        this.photo = photo;
    }

    public User(int id, String userName, String email, String password, String description, String name, String phoneNumber, int gender, int type, Blob photo) {
        this.id = id;
        this.userName = userName;
        this.email = email;
        this.password = password;
        this.description = description;
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.gender = gender;
        this.type = type;
        this.photo = photo;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public int getGender() {
        return gender;
    }

    public void setGender(int gender) {
        this.gender = gender;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public Blob getPhoto() {
        return photo;
    }

    public void setPhoto(Blob photo) {
        this.photo = photo;
    }
}
