package utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {
    private final Properties properties;

    public ConfigReader() {
        properties = new Properties();
        try {
            FileInputStream fis = new FileInputStream("/Users/amit/IdeaProjects/ElevateLifeStyle/src/resources/config.properties");
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

    public String getBrowser() {
        return properties.getProperty("browser");
    }
    public int getExplicitWait() {
        return Integer.parseInt(properties.getProperty("explicitWait"));
    }


}