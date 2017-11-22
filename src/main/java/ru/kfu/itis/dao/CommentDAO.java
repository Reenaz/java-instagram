package ru.kfu.itis.dao;

import ru.kfu.itis.entity.Comment;
import ru.kfu.itis.entity.Post;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * Created by Reenaz on 13.11.2017.
 */
public class CommentDAO extends AbstractDAO {

    public int add(Comment comment){

        Connection connection = getConnection();
        try {
            PreparedStatement ps = connection.prepareStatement("INSERT INTO \"java-instagram\".\"POSTS\"(POST_ID, USER_ID, TEXT, DATE) VALUES(?,?,?,?)");

            ps.setInt(1, comment.getPostId());
            ps.setInt(2, comment.getUserId());
            ps.setString(3, comment.getText());
            ps.setDate(4, comment.getDate());

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

}
