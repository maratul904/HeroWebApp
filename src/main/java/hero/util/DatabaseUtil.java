package com.hero.util;

import java.sql.Connection;
import java.sql.DriverManager;

public class DatabaseUtil {
    public static Connection getConnection() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            return DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/hero_db", "root", "");
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
