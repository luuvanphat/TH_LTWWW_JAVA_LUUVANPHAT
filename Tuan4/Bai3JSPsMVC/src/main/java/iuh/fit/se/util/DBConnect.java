package iuh.fit.se.util;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnect {
    private static final String URL = "jdbc:mariadb://localhost:3306/newsdb";
    private static final String USER = "root";
    private static final String PASS = "123456";

    public static Connection getConnection() {
        Connection conn = null;
        try {
            Class.forName("org.mariadb.jdbc.Driver");
            conn = DriverManager.getConnection(URL, USER, PASS);
            System.out.println(" Successfully connected to database");
        } catch (Exception e) {
            System.out.println(" Fail: " + e.getMessage());
            e.printStackTrace();
        }
        return conn;
    }

}

//CREATE DATABASE newsdb CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci;
//USE newsdb;
//
//CREATE TABLE TinTuc (
//        MaTT INT AUTO_INCREMENT PRIMARY KEY,
//        TieuDe VARCHAR(255) NOT NULL,
//NoiDungTT TEXT NOT NULL,
//LienKet VARCHAR(255),
//MaDM INT NOT NULL
//);

