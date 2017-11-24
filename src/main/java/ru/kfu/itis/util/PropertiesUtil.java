package ru.kfu.itis.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.kfu.itis.servlet.AddPostServlet;

import java.io.IOException;
import java.util.Properties;

public class PropertiesUtil {
    private final static Logger LOG = LoggerFactory.getLogger(AddPostServlet.class);

    private static Properties dbProperties;

    private static Properties getProperties(String name) throws IOException {
        Properties prop = new Properties();
        prop.load(Thread.currentThread().getContextClassLoader().getResourceAsStream(name));
        return prop;
    }

    public static Properties getDbProperties() {
        if (dbProperties==null){
            try {
                dbProperties = getProperties("db.properties");
            } catch (IOException e) {
                LOG.error("Error get db properties file", e);
            }
        }
        return dbProperties;
    }
}

