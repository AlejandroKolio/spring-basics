package com.udemy.spring.hb_00_first_lecture;

import com.udemy.spring.hb_00_first_lecture.entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 * @author alexander.shakhov on 11.05.2018 13:26.
 *
 * Creating a Student Class.
 *
 */
public class CreateStudentDemo {

    public static void main(String[] args) {
        //create session factory
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Student.class)
                .buildSessionFactory();

        //create session
        Session session = factory.getCurrentSession();

        try {
            //create object
            Student student = new Student("Paul", "Wall", "paul@luv2code.com");

            //start transaction
            System.out.println("Start transaction.");
            session.beginTransaction();

            //save object
            System.out.println("Saving object to db...");
            session.save(student);

            //commit transaction
            System.out.println("Commit transaction.");
            session.getTransaction().commit();

        } finally {
            factory.close();
        }
    }
}
