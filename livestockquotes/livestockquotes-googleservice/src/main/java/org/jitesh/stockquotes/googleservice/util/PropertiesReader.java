package org.jitesh.stockquotes.googleservice.util;

import java.io.InputStream;
import java.util.Properties;

public class PropertiesReader {

    private String propertyPath;


    public PropertiesReader(String propertyPath) {
        this.propertyPath = propertyPath;
    }

    public String getPropertyValue(String keyName) {
        String value = "";
        try {
            Properties prop = new Properties();
            InputStream inputStream = getClass().getClassLoader().getResourceAsStream(propertyPath);
            if (inputStream != null) {
                prop.load(inputStream);
                value = prop.getProperty(keyName);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return value;
    }
}
