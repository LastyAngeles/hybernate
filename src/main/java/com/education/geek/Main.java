package com.education.geek;

import com.education.geek.entities.Course;
import com.education.geek.entities.Student;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Student.class)
                .addAnnotatedClass(Course.class)
                .buildSessionFactory();

        Session session = null;

        try {
            session = factory.getCurrentSession();
            session.beginTransaction();
            Student student = session.get(Student.class, 2);
            System.out.println(student);
            session.getTransaction().commit();
        } finally {
            factory.close();
            session.close();
        }


    }
}
