package ru.kfu.itis.dao;

import ru.kfu.itis.entity.Like;
import ru.kfu.itis.entity.Post;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * Created by Reenaz on 13.11.2017.
 */
public class LikeDAO extends AbstractDAO {

    public int add(Like like){

        Connection connection = getConnection();
        try {
            PreparedStatement ps = connection.prepareStatement("INSERT INTO \"java-instagram\".\"POSTS\"(POST_ID, USER_ID) VALUES(?,?)");

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

}
