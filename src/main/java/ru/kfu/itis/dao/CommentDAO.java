package ru.kfu.itis.dao;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.kfu.itis.entity.Comment;
import ru.kfu.itis.entity.Post;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

public class CommentDAO extends AbstractDAO {
    private final static Logger LOG = LoggerFactory.getLogger(CommentDAO.class);

    public int add(Comment comment){

        Connection connection = getConnection();
        try {
            PreparedStatement ps = connection.prepareStatement("INSERT INTO \"java-instagram\".\"COMMENTS\"(\"POST_ID\", \"USER_ID\", \"TEXT\", \"DATE\") VALUES(?,?,?,current_date)");

            ps.setInt(1, comment.getPostId());
            ps.setInt(2, comment.getUserId());
            ps.setString(3, comment.getText());

            int result = ps.executeUpdate();

            ps.close();

            return result;
        } catch (SQLException e) {
            LOG.error("SQL error", e);
        } finally {
            closeConnection();
        }

        return 0;
    }

    public List<Comment> getCommentsByPostId(int postId) {
        List<Comment> comments = new LinkedList<>();
        Comment comment = null;
        Connection connection = getConnection();

        try{
            PreparedStatement ps = connection.prepareStatement("SELECT * FROM \"java-instagram\".\"COMMENTS\" WHERE \"POST_ID\"=?");

            ps.setInt(1, postId);

            ResultSet rs = ps.executeQuery();

            while(rs.next()) {
                comment = new Comment(
                        rs.getInt("ID"),
                        rs.getInt("POST_ID"),
                        rs.getInt("USER_ID"),
                        rs.getString("TEXT"),
                        rs.getDate("DATE")
                );

                comments.add(comment);
            }

        } catch (SQLException e) {
            LOG.error("SQL error", e);
        } finally {
            closeConnection();
        }

        return comments;
    }

    public int delete(int commentId) {
        Connection connection = getConnection();

        try {
            PreparedStatement ps = connection.prepareStatement("DELETE FROM \"java-instagram\".\"COMMENTS\" WHERE \"ID\"=?");

            ps.setInt(1, commentId);

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
