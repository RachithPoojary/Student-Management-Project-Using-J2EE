package com.company.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBUtil {
	 private static final String URL = "jdbc:postgresql://localhost:5432/projectDB";
	 private static final String USERNAME = "postgres";
	 private static final String PASSWORD = "root";
    static {
        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static Connection getConnection() throws SQLException {
//    	System.out.println("connection is built successfully");
        return DriverManager.getConnection(URL, USERNAME, PASSWORD);
    }
}