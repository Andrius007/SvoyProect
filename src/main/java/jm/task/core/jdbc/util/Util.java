package jm.task.core.jdbc.util;


import jm.task.core.jdbc.model.User;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;


public class Util {
    private static SessionFactory sessionFactory;

    public static SessionFactory getSessionFactory() {
        try {
            // Настройки hibernate
            Configuration configuration = new Configuration()
                    .setProperty( "hibernate.connection.driver_class",
                            "com.mysql.jdbc.Driver" )
                    .setProperty( "hibernate.connection.url",
                            "jdbc:mysql://localhost:3306/database123?useUnicode=true&useSSL=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC" )
                    .setProperty( "hibernate.connection.username",
                            "best" )
                    .setProperty( "hibernate.connection.password",
                            "best" )
                    .setProperty( "hibernate.dialect",
                            "org.hibernate.dialect.MySQLDialect" )
                    .setProperty( "hibernate.show_sql","true" )
                    .setProperty( "hibernate.current_session_context_class",
                            "thread" )
                    .setProperty("hibernate.hbm2ddl.auto", "update")

                    .addPackage( "ru.mysql.db" )
                    .addAnnotatedClass(User.class);

            StandardServiceRegistryBuilder registryBuilder = new StandardServiceRegistryBuilder()
                    .applySettings(configuration.getProperties());
            sessionFactory = configuration.buildSessionFactory(registryBuilder.build());
        } catch (Exception e) {
            System.out.println("Исключение! sessionFactory" + e);
        }
        return sessionFactory;
    }
}



