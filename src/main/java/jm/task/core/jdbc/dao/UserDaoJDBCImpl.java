package jm.task.core.jdbc.dao;

import jm.task.core.jdbc.model.User;
import jm.task.core.jdbc.util.Util;
import java.sql.*;
import java.util.List;

public class UserDaoJDBCImpl implements UserDao {
    Connection connection;
    public UserDaoJDBCImpl() {
        connection = new Util().connect();
    }
    public void createUsersTable() {
        try {
            connection.createStatement().executeUpdate("CREATE TABLE IF NOT EXISTS users (id BIGINT PRIMARY KEY AUTO_INCREMENT, " +
                    "name VARCHAR(20) NOT NULL, lastname VARCHAR(20) NOT NULL, age TINYINT NOT NULL)");
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
    public void dropUsersTable() {

        try {
            connection.createStatement().executeUpdate("DROP TABLE IF EXISTS users");
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
    public void saveUser(String name, String lastName, byte age) {
        try {
            connection.createStatement().executeUpdate("INSERT INTO users(name, lastname, age) VALUES ('"
                    + name + "', '"
                    + lastName + "', "
                    + age + ")");

            System.out.printf("User с именем – %s добавлен в базу данных" + '\n', name);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public void removeUserById(long id) {
        try {
            connection.createStatement().executeUpdate("DELETE FROM users WHERE id = " + id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<User> getAllUsers() {

        ResultSet rs;
        try {
            rs = connection.createStatement().executeQuery("SELECT * FROM users");
            while (rs.next()){
                getAllUsers().add(new User(rs.getString(2), rs.getString(3), rs.getByte(4)));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public void cleanUsersTable() {

        try {
            connection.createStatement().executeUpdate("TRUNCATE TABLE users");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
