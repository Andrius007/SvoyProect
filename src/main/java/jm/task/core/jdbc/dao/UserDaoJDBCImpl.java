package jm.task.core.jdbc.dao;

import jm.task.core.jdbc.model.User;
import jm.task.core.jdbc.util.Util;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserDaoJDBCImpl implements UserDao {
    Connection connection;
    public UserDaoJDBCImpl() {
        connection = new Util().connect();
    }

    public void createUsersTable() {
        try (Connection connection = Util.getUtilConnection()) {
            try (Statement statement = connection.createStatement()) {
                statement.executeUpdate("CREATE TABLE IF NOT EXISTS users " +
                        "(id BIGINT(19) NOT NULL AUTO_INCREMENT, " +
                        "name VARCHAR(45) NOT NULL," +
                        "lastname VARCHAR(45) NOT NULL, " +
                        "age TINYINT(3) NOT NULL, " +
                        "PRIMARY KEY (id));");

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public void dropUsersTable() {

        try (Connection connection = Util.getUtilConnection();

             Statement statement = connection.createStatement()) {

            statement.executeUpdate("DROP TABLE IF EXISTS users;");

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public void saveUser(String name, String lastName, byte age) {
        try (Connection connection = Util.getUtilConnection();

             PreparedStatement preparedStatement = connection.prepareStatement(
                     "INSERT INTO users (name, lastname, age) Values (?, ?, ?);")) {


            preparedStatement.setString(1, name);
            preparedStatement.setString(2, lastName);
            preparedStatement.setInt(3, age);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void removeUserById(long id) {

        try (Connection connection = Util.getUtilConnection();

             PreparedStatement preparedStatement = connection.prepareStatement("DELETE FROM users WHERE id = ?;")) {
            preparedStatement.setLong(1, id);
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public List<User> getAllUsers() {

        return null;
        List<User> list = new ArrayList<>();
        ResultSet rs;
        try {
            rs = connection.createStatement().executeQuery("SELECT * FROM usersTable");
            while (rs.next()){
                list.add(new User(rs.getString(2), rs.getString(3), rs.getByte(4)));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    public void cleanUsersTable() {

        try (Connection connection = Util.getUtilConnection();

             PreparedStatement preparedStatement = connection.prepareStatement("TRUNCATE users;")) {

            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
