package ru.kfu.itis.dao;

import ru.kfu.itis.entity.Like;
import ru.kfu.itis.entity.Post;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class LikeDAO extends AbstractDAO {

    public int add(Like like){

        Connection connection = getConnection();
        try {
            PreparedStatement ps = connection.prepareStatement("INSERT INTO \"java-instagram\".\"LIKES\"(\"POST_ID\", \"USER_ID\") VALUES(?,?)");

            ps.setInt(1, like.getPostId());
            ps.setInt(2, like.getUserId());


            int result = ps.executeUpdate();

            ps.close();

            return result;
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeConnection();
        }

        return 0;
    }

    public int delete(int userId, int postId) {
        Connection connection = getConnection();

        try {
            PreparedStatement ps = connection.prepareStatement("DELETE FROM \"java-instagram\".\"LIKES\" WHERE \"USER_ID\"=? AND \"POST_ID\"=?");

            ps.setInt(1, userId);
            ps.setInt(2, postId);

            int result = ps.executeUpdate();

            return result;
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeConnection();
        }

        return 0;
    }

    public Like get(int userId, int postId) {
        Connection connection = getConnection();
        Like like = null;

        try {
            PreparedStatement ps = connection.prepareStatement("SELECT * FROM \"java-instagram\".\"LIKES\" WHERE \"USER_ID\"=? AND \"POST_ID\"=?");

            ps.setInt(1, userId);
            ps.setInt(2, postId);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                like = new Like(
                        rs.getInt("ID"),
                        rs.getInt("POST_ID"),
                        rs.getInt("USER_ID")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeConnection();
        }

        return like;
    }



}
