package ru.folder.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import ru.folder.models.Car;
import ru.folder.models.User;

import java.util.List;

public class Application {
    public static void main(String[] args) {
        Configuration configuration = new Configuration();
        configuration.setProperty("hibernate.connection.url", "jdbc:postgresql://localhost:5433/UserApartmentCar");
        configuration.setProperty("hibernate.connection.username", "postgres");
        configuration.setProperty("hibernate.connection.password", "*****");
        configuration.setProperty("hibernate.connection.url", "jdbc:postgresql://localhost:5433/UserApartmentCar");
        configuration.setProperty("hibernate.connection.driver_class", "org.postgresql.Driver");
        configuration.setProperty("hibernate.dialect", "org.hibernate.dialect.PostgreSQL95Dialect");
        configuration.setProperty("hibernate.hbm2ddl.auto", "update");
        configuration.addResource("User.hbm.xml");
        configuration.setProperty("hibernate.show_sql", "true");
        configuration.addAnnotatedClass(Car.class); //чтобы пользоваться аннтоциями
        SessionFactory sessionFactory = configuration.buildSessionFactory();

        Session session = sessionFactory.openSession();
        User user = session.createQuery("from User user where user.id = 1", User.class).getSingleResult();

        session.beginTransaction();
        session.save(new User("Mini", "Max", 99));
        session.getTransaction().commit();
        System.out.println(user);

        List<Car> cars = session.createQuery("from Car car", Car.class).getResultList();//запросили список всех машин

    }
}
