package ru.kfu.itis.dao;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.kfu.itis.entity.Post;
import ru.kfu.itis.entity.User;

import java.sql.*;
import java.util.LinkedList;
import java.util.List;

public class PostDAO extends AbstractDAO {
    private final static Logger LOG = LoggerFactory.getLogger(PostDAO.class);

    public int add(Post post){
        Connection connection = getConnection();
        int postId = -1;

        try {
            PreparedStatement ps = connection.prepareStatement("INSERT INTO \"java-instagram\".\"POSTS\"(\"USER_ID\", \"PHOTO_URL\", \"DESCRIPTION\", \"LOCATION\", \"DATE\", \"LIKES_COUNT\") VALUES(?,?,?,?, current_timestamp,?)", new String[]{"ID"});

            ps.setInt(1, post.getUserId());
            ps.setString(2, post.getPhoto());
            ps.setString(3, post.getDescription());
            ps.setString(4, post.getLocation());
            ps.setInt(5, post.getLikesCount());


            ps.executeUpdate();

            ResultSet rs = ps.getGeneratedKeys();

            while(rs.next()) {
                postId = rs.getInt(1);
            }

            ps.close();

        } catch (SQLException e) {
            LOG.error("SQL error", e);
        } finally {
            closeConnection();
        }

        return postId;
    }

    public Post get(int postId) {
        Connection connection = getConnection();
        Post post = null;

        try {
            PreparedStatement ps = connection.prepareStatement("SELECT * FROM \"java-instagram\".\"POSTS\" WHERE \"ID\"=?");

            ps.setInt(1, postId);

            ResultSet rs = ps.executeQuery();

            while(rs.next()){
                post = new Post(
                        rs.getInt("ID"),
                        rs.getInt("USER_ID"),
                        rs.getString("PHOTO_URL"),
                        rs.getString("DESCRIPTION"),
                        rs.getString("LOCATION"),
                        rs.getDate("DATE"),
                        rs.getInt("LIKES_COUNT")
                );

            }
        } catch (SQLException e) {
            LOG.error("SQL error", e);
        } finally {
            closeConnection();
        }

        return post;
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
                        rs.getString("LOCATION"),
                        rs.getDate("DATE"),
                        rs.getInt("LIKES_COUNT")
                );

                posts.add(post);
            }
        } catch (SQLException e) {
            LOG.error("SQL error", e);
        } finally {
            closeConnection();
        }

        return posts;
    }

    public List<Post> getAllPostsByUserId(int userId) {
        List<Post> posts = new LinkedList<>();
        Post post = null;
        Connection connection = getConnection();

        try {
            PreparedStatement ps = connection.prepareStatement("SELECT * FROM \"java-instagram\".\"POSTS\" WHERE \"USER_ID\"=? ");
            //Array array = connection.createArrayOf("Integer", userIdList.toArray());
            ps.setInt(1, userId);

            ResultSet rs = ps.executeQuery();

            while(rs.next()) {
                post = new Post(
                        rs.getInt("ID"),
                        rs.getInt("USER_ID"),
                        rs.getString("PHOTO_URL"),
                        rs.getString("DESCRIPTION"),
                        rs.getString("LOCATION"),
                        rs.getDate("DATE"),
                        rs.getInt("LIKES_COUNT")
                );
                posts.add(post);


            }
        } catch (SQLException e) {
            LOG.error("SQL error", e);
        } finally {
            closeConnection();
        }

        return posts;
    }

    public int updateLikesCoung(int postID , int coint) {
        Connection connection = getConnection();

        try {
            PreparedStatement ps = connection.prepareStatement("UPDATE \"java-instagram\".\"POSTS\" SET \"LIKES_COUNT\"=? WHERE \"ID\"=? ");

            ps.setInt(1, coint);
            ps.setInt(2, postID);

            int result = ps.executeUpdate();

            return result;

        } catch (SQLException e) {
            LOG.error("SQL error", e);
        } finally {
            closeConnection();
        }

        return 0;
    }



}
