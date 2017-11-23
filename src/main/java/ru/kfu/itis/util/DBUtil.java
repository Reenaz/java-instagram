package ru.kfu.itis.util;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DBUtil {
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
                // log an exception. fro example:
                System.out.println("Failed to create the database connection.");
            }
        } catch (ClassNotFoundException ex) {
            // log an exception. for example:
            System.out.println("Driver not found.");
            ex.printStackTrace();

        }
        return connection;
    }
}
