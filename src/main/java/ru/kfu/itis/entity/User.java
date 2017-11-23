package ru.kfu.itis.entity;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.sql.Blob;
import java.util.Arrays;

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
    private String photo;

    public User() {
    }

    public User(String userName, String email, String password, String description, String name, String phoneNumber, int gender, int type, String photo) {
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

    public User(int id, String userName, String email, String password, String description, String name, String phoneNumber, int gender, int type) {
        this.id = id;
        this.userName = userName;
        this.email = email;
        this.password = password;
        this.description = description;
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.gender = gender;
        this.type = type;
    }

    public User(int id, String userName, String email, String password, String description, String name, String phoneNumber, int gender, int type, String photo) {
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

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", userName='" + userName + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", description='" + description + '\'' +
                ", name='" + name + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", gender=" + gender +
                ", type=" + type +
                ", photo='" + photo + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        User user = (User) o;

        if (id != user.id) return false;
        if (gender != user.gender) return false;
        if (type != user.type) return false;
        if (userName != null ? !userName.equals(user.userName) : user.userName != null) return false;
        if (email != null ? !email.equals(user.email) : user.email != null) return false;
        if (password != null ? !password.equals(user.password) : user.password != null) return false;
        if (description != null ? !description.equals(user.description) : user.description != null) return false;
        if (name != null ? !name.equals(user.name) : user.name != null) return false;
        if (phoneNumber != null ? !phoneNumber.equals(user.phoneNumber) : user.phoneNumber != null) return false;
        return photo != null ? photo.equals(user.photo) : user.photo == null;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (userName != null ? userName.hashCode() : 0);
        result = 31 * result + (email != null ? email.hashCode() : 0);
        result = 31 * result + (password != null ? password.hashCode() : 0);
        result = 31 * result + (description != null ? description.hashCode() : 0);
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (phoneNumber != null ? phoneNumber.hashCode() : 0);
        result = 31 * result + gender;
        result = 31 * result + type;
        result = 31 * result + (photo != null ? photo.hashCode() : 0);
        return result;
    }
}
