package jm.task.core.jdbc;

import jm.task.core.jdbc.dao.UserDaoJDBCImpl;
import jm.task.core.jdbc.util.Util;

public class Main {
    public static void main(String[] args) {
       // UserDaoJDBCImpl userDaoJDBC = new UserDaoJDBCImpl();
        Util.connect();
        // userDaoJDBC.createUsersTable();
        // userDaoJDBC.saveUser("Петр", " Петров", (byte) 19);
        // userDaoJDBC.saveUser("Иван", "Иванов", (byte) 45);
        // userDaoJDBC.saveUser("Сергей", "Сергеев", (byte) 45);
        // userDaoJDBC.saveUser("Александр", "Александров", (byte) 3);
        // System.out.println(userDaoJDBC.getAllUsers());
        // userDaoJDBC.cleanUsersTable();
        // userDaoJDBC.dropUsersTable();

    }
}
