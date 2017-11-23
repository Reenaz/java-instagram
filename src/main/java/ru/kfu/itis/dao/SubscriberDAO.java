package ru.kfu.itis.dao;

import ru.kfu.itis.entity.Comment;
import ru.kfu.itis.entity.Subscriber;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;


public class SubscriberDAO extends AbstractDAO {

    public int add(Subscriber subscriber){

        Connection connection = getConnection();
        try {
            PreparedStatement ps = connection.prepareStatement("INSERT INTO \"java-instagram\".\"SUBSCRIBERS\" (\"SUBSCRIBER_ID\", \"PERSON_ID\", \"DATE\") VALUES(?,?,current_date)");

            ps.setInt(1, subscriber.getSubscriberId());
            ps.setInt(2, subscriber.getPersonId());

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

    public int delete(int subId, int personId) {
        Connection connection = getConnection();
        try {
            PreparedStatement ps = connection.prepareStatement("DELETE FROM \"java-instagram\".\"SUBSCRIBERS\" WHERE \"SUBSCRIBER_ID\"=? AND \"PERSON_ID\"=?");

            ps.setInt(1, subId);
            ps.setInt(2, personId);

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

    public int isSubscribed(int subId, int personId) {
        Connection connection = getConnection();
        int result=0;

        try {
            PreparedStatement ps =connection.prepareStatement("SELECT COUNT(*) AS COUNT FROM \"java-instagram\".\"SUBSCRIBERS\" WHERE \"SUBSCRIBER_ID\"=? AND \"PERSON_ID\"=?");

            ps.setInt(1, subId);
            ps.setInt(2, personId);

           ResultSet rs = ps.executeQuery();
           while(rs.next()) {
               result = rs.getInt("COUNT");
           }

            ps.close();

            return result;

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeConnection();
        }

        return result;
    }

    public int getCountOfSubscribers(int userId) {
        int count = 0;
        Connection connection = getConnection();

        try {
            PreparedStatement ps = connection.prepareStatement("SELECT COUNT(DISTINCT \"PERSON_ID\") AS COUNT FROM \"java-instagram\".\"SUBSCRIBERS\" WHERE \"PERSON_ID\" = ? ");

            ps.setInt(1, userId);

            ResultSet rs = ps.executeQuery();

            while(rs.next()) {
                count = rs.getInt("COUNT");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeConnection();
        }

        return count;
    }

    public int getCountOfPersonToSub( int userId) {
        int count = 0;
        Connection connection = getConnection();

        try {
            PreparedStatement ps = connection.prepareStatement("SELECT COUNT(DISTINCT \"PERSON_ID\") AS COUNT FROM \"java-instagram\".\"SUBSCRIBERS\" WHERE \"SUBSCRIBER_ID\" = ? ");

            ps.setInt(1, userId);

            ResultSet rs = ps.executeQuery();

            while(rs.next()) {
                count = rs.getInt("COUNT");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeConnection();
        }

        return count;
    }

    public List<Integer> getAllPersonIdOfSub(int userId) {
        List<Integer> personIdList = new LinkedList<>();
        Integer personId;
        Connection connection = getConnection();

        try {
            PreparedStatement ps = connection.prepareStatement("SELECT \"PERSON_ID\" FROM \"java-instagram\".\"SUBSCRIBERS\" WHERE \"SUBSCRIBER_ID\" = ? ");

            ps.setInt(1, userId);

            ResultSet rs = ps.executeQuery();

            while(rs.next()) {
                personId = rs.getInt("PERSON_ID");
                personIdList.add(personId);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeConnection();
        }

        return personIdList;
    }
}
