package org.example.datatest.utils;


import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ConfigReader {
    private static volatile ConfigReader instance;
    private static Properties properties ;

    private ConfigReader() {
        try {
            InputStream file = ConfigReader.class.getClassLoader().getResourceAsStream("data/file.properties");
            properties = new Properties();
            properties.load(file);
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException("Failed to load configuration file!");
        }
    }

    public static ConfigReader getInstance(){
        if (instance==null){
            synchronized (ConfigReader.class){
                if (instance==null){
                    instance=new ConfigReader();
                }
            }
        }
        return instance;
    }

    public String getProperty(String key){
        return properties.getProperty(key);
    }

}
