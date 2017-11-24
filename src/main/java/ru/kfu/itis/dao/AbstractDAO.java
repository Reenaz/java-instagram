package ru.kfu.itis.dao;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.kfu.itis.util.DBUtil;

import java.sql.Connection;
import java.sql.SQLException;


public class AbstractDAO {
    private final static Logger LOG = LoggerFactory.getLogger(AbstractDAO.class);

    private Connection connection;

    protected Connection getConnection(){

        try {
            if (connection!=null && !connection.isClosed()){
                return connection;
            } else {
                connection = DBUtil.getConnection();
            }
        } catch (SQLException e) {
            LOG.error("Error get connection", e);
        }
        return connection;
    }

    protected void closeConnection(){
        try {
            if (connection!=null && !connection.isClosed()){
                connection.close();
            }
        } catch (SQLException e) {
            LOG.error("Error close connection", e);
        }
    }
}
