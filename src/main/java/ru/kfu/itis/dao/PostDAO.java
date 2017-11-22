package ru.kfu.itis.dao;

import ru.kfu.itis.entity.Post;
import ru.kfu.itis.entity.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by Reenaz on 13.11.2017.
 */
public class PostDAO extends AbstractDAO {

    public int add(Post post){
        Connection connection = getConnection();
        int postId = -1;

        try {
            PreparedStatement ps = connection.prepareStatement("INSERT INTO \"java-instagram\".\"POSTS\"(\"USER_ID\", \"PHOTO_URL\", \"DESCRIPTION\", \"LOCATION\") VALUES(?,?,?,?)", new String[]{"ID"});

            ps.setInt(1, post.getUserId());
            ps.setString(2, post.getPhoto());
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

    public List<Post> findByUserId(int id) {
        Connection connection = getConnection();
        List<Post> posts = new LinkedList<Post>();
        Post post = null;

        try {
            PreparedStatement ps = connection.prepareStatement("SELECT * FROM \"java-instagram\".\"POSTS\" WHERE \"USER_ID\"=?");

            ps.setInt(1, id);

            ResultSet rs = ps.executeQuery();

            while(rs.next()){
                post = new Post(
                        rs.getInt("ID"),
                        rs.getInt("USER_ID"),
                        rs.getString("PHOTO_URL"),
                        rs.getString("DESCRIPTION"),
                        rs.getString("LOCATION")
                );

                posts.add(post);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeConnection();
        }

        return posts;
    }



}
