package jm.task.core.jdbc.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Util {
    private static final String URL = "jdbc:mariadb://localhost:3306/database123";
    private static final String URLFIXED =  "jdbc:mysql://localhost:3306/database123?useUnicode=true&useSSL=true&useJDBCCompliantTimezoneShift=true";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "root";

    private static Connection connection;

    public Util() {
    }

    public static Connection getUtilConnection() { // геттер приватного поля connection + создаем connection
        try {
            connection = DriverManager.getConnection(URLFIXED, USERNAME, PASSWORD);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return connection;
    }

    public Connection connect() {
        return null;
    }
}
