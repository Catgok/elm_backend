package com.elm.util;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBUtil {
    private static final String URL = ConfigManager.getProp("URL");
    private static final String DRIVER = ConfigManager.getProp("DRIVER");
    private static final String USERNAME = ConfigManager.getProp("USERNAME");
    private static final String PASSWORD = ConfigManager.getProp("PASSWORD");

    private static final ThreadLocal<Connection> TL = new ThreadLocal<>();

    private static Connection createConnection() {
        Connection con = null;
        try {
            Class.forName(DRIVER);
            con = DriverManager.getConnection(URL, USERNAME, PASSWORD);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return con;
    }

    public static Connection getConnection() {
        Connection con = null;
        con = TL.get();
        if (con == null) {
            con = createConnection();
            TL.set(con);
        }
        return con;
    }
}
