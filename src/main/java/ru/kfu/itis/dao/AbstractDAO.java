package ru.kfu.itis.dao;

import ru.kfu.itis.util.DBUtil;

import java.sql.Connection;
import java.sql.SQLException;

/**
 * Created by Reenaz on 13.11.2017.
 */
public class AbstractDAO {
    private Connection connection;

    protected Connection getConnection(){

        try {
            if (connection!=null && !connection.isClosed()){
                return connection;
            } else {
                connection = DBUtil.getConnection();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }

    protected void closeConnection(){
        try {
            if (connection!=null && !connection.isClosed()){
                connection.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
