package com.mylearning.hibernateexamples;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateBasicExample {
    public static void main(String[] args) {
        SessionFactory sessionFactory = new Configuration().configure()
                .buildSessionFactory();

        Session session = sessionFactory.openSession();
        session.beginTransaction();

        Employees employee = new Employees();
        employee.setName("ravi");
        employee.setEmail("ravi@gmail.com");

        session.save(employee);

        session.getTransaction().commit();
        session.close();

        sessionFactory.close();
    }
}
