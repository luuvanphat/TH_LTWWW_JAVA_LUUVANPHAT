package iuh.fit.se.bai2formmvc.database;

import java.sql.Connection;
import java.sql.DriverManager;


public class DBUtil {
    private static final String URL = "jdbc:mariadb://localhost:3306/userdb";
    private static final String USER = "root";
    private static final String PASSWORD = "123456";

    public static Connection getConnection() {
        Connection conn = null;
        try {
            Class.forName("org.mariadb.jdbc.Driver");
            conn = DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return conn;
    }
}

