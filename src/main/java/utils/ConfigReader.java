package utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {
    private final Properties properties;

    public ConfigReader() {
        properties = new Properties();
        try {
            FileInputStream fis = new FileInputStream("/Users/amit/IdeaProjects/UrbanLifeStyle/src/resources/config.properties");
            properties.load(fis);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String getBaseUrl() {
        return properties.getProperty("base.url");
    }

    public String getAdminUsername() {
        return properties.getProperty("admin.username");
    }

    public String getAdminPassword() {
        return properties.getProperty("admin.password");
    }
    public String getInvalidUsername() {
        return properties.getProperty("invalid.username");
    }

    public String getInvalidPassword() {
        return properties.getProperty("invalid.password");
    }

    public int getExplicitWait() {
        String waitTime = properties.getProperty("explicitWait");
        if (waitTime == null || waitTime.trim().isEmpty()) {
            return 10; // default value
        }
        return Integer.parseInt(waitTime);
    }



}