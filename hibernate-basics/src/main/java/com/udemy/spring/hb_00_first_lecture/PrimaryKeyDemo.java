package com.udemy.spring.hb_00_first_lecture;

import com.udemy.spring.hb_00_first_lecture.entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 * @author alexander.shakhov on 14.05.2018 12:00
 * @project spring-basics
 * @description
 */
public class PrimaryKeyDemo {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Student.class)
                .buildSessionFactory();

        //create session
        Session session = factory.getCurrentSession();

        try{
            //create 3 student objects
            System.out.println("Creating 3 student objects...");
            Student student1 = new Student("John", "Doe", "john@luv2code.com");
            Student student2 = new Student("Mary", "Public", "mary@luv2code.com");
            Student student3 = new Student("Bonita", "Applebum", "bonita@luv2code.com");

            //start transaction
            System.out.println("Starting transaction");
            session.beginTransaction();

            //save object
            System.out.println("Saving students...");
            session.save(student1);
            session.save(student2);
            session.save(student3);

            //commit transaction
            System.out.println("Committing multiple transactions");
            session.getTransaction().commit();

        } finally {
            factory.close();
        }
    }
}
