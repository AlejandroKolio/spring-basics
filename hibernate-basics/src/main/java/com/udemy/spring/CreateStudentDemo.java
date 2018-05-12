package com.udemy.spring;

import com.udemy.spring.entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 * @author alexander.shakhov on 11.05.2018 13:26
 * @project spring-basics
 * @description
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

        try{
            //create object
            Student student = new Student("Paul", "Wall", "paul@luv2code.com");

            //start transaction
            session.beginTransaction();

            //save object
            session.save(student);

            //commit transaction
            session.getTransaction().commit();

        } finally {
            factory.close();
        }
    }
}
