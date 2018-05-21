package com.udemy.spring.hb_00_first_lecture;

import com.udemy.spring.hb_00_first_lecture.entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 * @author alexander.shakhov on 14.05.2018 13:00
 * @project com.udemy.spring.spring-basics
 * @description
 */
public class ReadStudentDemo {
    public static void main(String[] args) {
        //create session factory
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Student.class)
                .buildSessionFactory();

        //create session
        Session session = factory.getCurrentSession();

        try {
            //create 3 student objects
            System.out.println("Creating 3 student objects...");
            Student daffy = new Student("Daffy", "Duck", "daffy@luv2code.com");

            //start transaction
            System.out.println("Starting transaction");
            session.beginTransaction();

            //save object
            System.out.println("Saving students...");
            session.save(daffy);

            //commit transaction
            System.out.println("Committing multiple transactions");
            session.getTransaction().commit();

            //retrieving object from DB
            System.out.println("Get ID: " + daffy.getId());
            session = factory.getCurrentSession();
            session.beginTransaction();
            Student student = session.get(Student.class, daffy.getId());
            System.out.println("Get complete: " + student);

            //commit the transaction
            session.getTransaction().commit();

            System.out.println("Done");

        } finally {
            factory.close();
        }
    }
}
