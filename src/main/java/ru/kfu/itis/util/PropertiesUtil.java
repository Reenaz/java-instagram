package ru.kfu.itis.util;

import java.io.IOException;
import java.util.Properties;

/**
 * Created by Reenaz on 13.11.2017.
 */
public class PropertiesUtil {
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
                e.printStackTrace();
            }
        }
        return dbProperties;
    }
}

