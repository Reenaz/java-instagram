package ru.kfu.itis.dao;

import ru.kfu.itis.entity.Post;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by Reenaz on 13.11.2017.
 */
public class PostDAO extends AbstractDAO {

    public int add(Post post){
        Connection connection = getConnection();
        int postId = -1;

        try {
            PreparedStatement ps = connection.prepareStatement("INSERT INTO \"java-instagram\".POSTS(USER_ID, PHOTO, DESCRIPTION, LOCATION) VALUES(?,?,?,?)", new String[]{"ID"});

            ps.setInt(1, post.getUserId());
            ps.setBlob(2, post.getPhoto());
            ps.setString(3, post.getDescription());
            ps.setString(4, post.getLocation());

            ps.executeUpdate();

            ResultSet rs = ps.getGeneratedKeys();

            while(rs.next()) {
                postId = rs.getInt(1);
            }

            ps.close();

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeConnection();
        }

        return postId;
    }



}
