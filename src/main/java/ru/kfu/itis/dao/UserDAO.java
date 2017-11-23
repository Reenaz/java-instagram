package ru.kfu.itis.dao;

import ru.kfu.itis.entity.Post;
import ru.kfu.itis.entity.User;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.net.ConnectException;
import java.sql.*;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;


public class UserDAO extends AbstractDAO{

    public int add(User user) {
        Connection connection = getConnection();
        int userId = -1;

        try {
            PreparedStatement ps = connection.prepareStatement("INSERT INTO \"java-instagram\".\"USERS\"(\"USERNAME\", \"EMAIL\", \"PASSWORD\", \"DESCRIPTION\", \"NAME\", \"PHONE_NUMBER\", \"GENDER\", \"TYPE\", \"PHOTO_URL\") VALUES(?,?,?,?,?,?,?,?,?)", new String[]{"ID"});

            ps.setString(1, user.getUserName());
            ps.setString(2, user.getEmail());
            ps.setString(3, user.getPassword());
            ps.setString(4, user.getDescription());
            ps.setString(5, user.getName());
            ps.setString(6, user.getPhoneNumber());
            ps.setInt(7, user.getGender());
            ps.setInt(8, user.getType());
            ps.setString(9, user.getPhoto());

            ps.executeUpdate();

            ResultSet rs = ps.getGeneratedKeys();
            while(rs.next()) {
                userId = rs.getInt(1);
            }

            ps.close();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeConnection();
        }

        return userId;
    }

    public User get(int id) {
        Connection connection = getConnection();
        User user = null;

        try {
            PreparedStatement ps = connection.prepareStatement("SELECT * FROM \"java-instagram\".\"USERS\" WHERE \"ID\"=?");

            ps.setInt(1, id);

            ResultSet rs = ps.executeQuery();

            while(rs.next()){
                user = new User(
                        rs.getInt("ID"),
                        rs.getString("USERNAME"),
                        rs.getString("EMAIL"),
                        rs.getString("PASSWORD"),
                        rs.getString("DESCRIPTION"),
                        rs.getString("NAME"),
                        rs.getString("PHONE_NUMBER"),
                        rs.getInt("GENDER"),
                        rs.getInt("TYPE"),
                        rs.getString("PHOTO_URL")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeConnection();
        }

        return user;
    }


    public User findByUserName(String userName) {
        Connection connection = getConnection();
        User user = null;

        try {
            PreparedStatement ps = connection.prepareStatement("SELECT * FROM \"java-instagram\".\"USERS\" WHERE \"USERNAME\"=?");

            ps.setString(1, userName);

            ResultSet rs = ps.executeQuery();

            while(rs.next()) {
                user = new User(
                        rs.getInt("ID"),
                        rs.getString("USERNAME"),
                        rs.getString("EMAIL"),
                        rs.getString("PASSWORD"),
                        rs.getString("DESCRIPTION"),
                        rs.getString("NAME"),
                        rs.getString("PHONE_NUMBER"),
                        rs.getInt("GENDER"),
                        rs.getInt("TYPE"),
                        rs.getString("PHOTO_URL")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeConnection();
        }

        return user;
    }

    public int update(User user) {
        Connection connection = getConnection();

        try{
            PreparedStatement ps = connection.prepareStatement("UPDATE \"java-instagram\".\"USERS\" SET \"EMAIL\"=?, \"PASSWORD\"=?, \"DESCRIPTION\"=?, \"NAME\"=?, \"PHONE_NUMBER\"=?, \"GENDER\"=?, \"TYPE\"=? , \"PHOTO_URL\"=? WHERE \"USERNAME\"=?");

            ps.setString(1, user.getEmail());
            ps.setString(2, user.getPassword());
            ps.setString(3, user.getDescription());
            ps.setString(4, user.getName());
            ps.setString(5, user.getPhoneNumber());
            ps.setInt(6, user.getGender());
            ps.setInt(7, user.getType());
            ps.setString(8, user.getPhoto());
            ps.setString(9, user.getUserName());

            int result = ps.executeUpdate();

            return result;

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeConnection();
        }

        return 0;

    }

    public String getProfilePhotoById(int userId) {
        String photoUrl = null;
        Connection connection = getConnection();

        try {
            PreparedStatement ps = connection.prepareStatement("SELECT \"PHOTO_URL\"  FROM \"java-instagram\".\"USERS\" WHERE \"ID\"=? ");

            ps.setInt(1, userId);
            ResultSet rs = ps.executeQuery();

            while(rs.next()) {
                photoUrl = rs.getString("PHOTO_URL");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeConnection();
        }

        return photoUrl;
    }


}
