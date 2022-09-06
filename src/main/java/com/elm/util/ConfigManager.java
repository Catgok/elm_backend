package com.elm.util;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ConfigManager {
    private static final Properties conf = new Properties();

    static {
        InputStream in = ConfigManager.class.getClassLoader().getResourceAsStream("config.properties");
        try {
            conf.load(in);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static String getProp(String key) {
        return conf.getProperty(key);
    }
}