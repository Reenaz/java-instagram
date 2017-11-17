package ru.kfu.itis.dao;

import ru.kfu.itis.entity.User;

import java.net.ConnectException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by Reenaz on 13.11.2017.
 */
public class UserDAO extends AbstractDAO{

    public int add(User user) {
        Connection connection = getConnection();
        int userId = -1;

        try {
            PreparedStatement ps = connection.prepareStatement("INSERT INTO \"java-instagram\".USERS(USERNAME, EMAIL, PASSWORD, DESCRIPTION, NAME, PHONE_NUMBER, GENDER, TYPE, PHOTO) VALUES(?,?,?,?,?,?,?,?,?)", new String[]{"ID"});

            ps.setString(1, user.getUserName());
            ps.setString(2, user.getEmail());
            ps.setString(3, user.getPassword());
            ps.setString(4, user.getDescription());
            ps.setString(5, user.getName());
            ps.setString(6, user.getPhoneNumber());
            ps.setInt(7, user.getGender());
            ps.setInt(8, user.getType());
            ps.setBlob(9, user.getPhoto());

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
            PreparedStatement ps = connection.prepareStatement("SELECT * FROM USERS WHERE ID=?");

            ps.setInt(1, id);

            ResultSet rs = ps.executeQuery();

            while(rs.next()){
                user = new User(
                        id,
                        rs.getString("USERNAME"),
                        rs.getString("EMAIL"),
                        rs.getString("PASSWORD"),
                        rs.getString("DESCRIPTION"),
                        rs.getString("NAME"),
                        rs.getString("PHONE_NUMBER"),
                        rs.getInt("GENDER"),
                        rs.getInt("TYPE"),
                        rs.getBlob("PHOTO")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeConnection();
        }

        return user;
    }


}