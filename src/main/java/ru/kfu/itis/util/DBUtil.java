package ru.kfu.itis.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.kfu.itis.entity.Like;
import ru.kfu.itis.servlet.AddPostServlet;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DBUtil {
    private final static Logger LOG = LoggerFactory.getLogger(AddPostServlet.class);

    private static DataSource dataSource;

    private static Connection connection;

    private static Properties propertiesDB = PropertiesUtil.getDbProperties();

    private static final String DRIVER_DB = propertiesDB.getProperty("driver");
    private static final String URL_DB = propertiesDB.getProperty("url");
    private static final String USERNAME_DB = propertiesDB.getProperty("username");
    private static final String PASSWORD_DB = propertiesDB.getProperty("password");

    public static Connection getConnection() {
        try {
            Class.forName(DRIVER_DB);
            try {
                connection = DriverManager.getConnection(URL_DB, USERNAME_DB, PASSWORD_DB);
            } catch (SQLException ex) {
                LOG.error("Failed to create the database connection.", ex);
            }
        } catch (ClassNotFoundException ex) {
            LOG.error("Driver not found.", ex);

        }
        return connection;
    }
}
