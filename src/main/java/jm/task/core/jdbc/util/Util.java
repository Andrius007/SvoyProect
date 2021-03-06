package jm.task.core.jdbc.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Util {
    private static final String DRIVER= "jdbc:mariadb://localhost:3306/database123";
    private static final String URL =  "jdbc:mysql://localhost:3306/database123?useUnicode=true&useSSL=true&useJDBCCompliantTimezoneShift=true";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "root";

    Connection connection= null;

    public Connection connect() {

        try {
            Class.forName(DRIVER);
            connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            System.out.println("Соединение установлено");

        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }
}
