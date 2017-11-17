package ru.kfu.itis.dao;

import ru.kfu.itis.entity.Comment;
import ru.kfu.itis.entity.Subscriber;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * Created by Reenaz on 13.11.2017.
 */
public class SubscriberDAO extends AbstractDAO {

    public int add(Subscriber subscriber){

        Connection connection = getConnection();
        try {
            PreparedStatement ps = connection.prepareStatement("INSERT INTO \"java-instagram\".POSTS(SUBSCRIBER_ID, PERSON_ID, DATE) VALUES(?,?,?)");

            ps.setInt(1, subscriber.getSubscriberId());
            ps.setInt(2, subscriber.getPersonId());
            ps.setDate(3, subscriber.getDate());

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
