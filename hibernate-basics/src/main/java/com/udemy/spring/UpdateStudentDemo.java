package com.udemy.spring;

import com.udemy.spring.entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 * @author alexander.shakhov on 11.05.2018 13:26
 */
public class UpdateStudentDemo {

    public static void main(String[] args) {
        //create session factory
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Student.class)
                .buildSessionFactory();

        //1. create session
        Session session = factory.getCurrentSession();

        try {
            //2. start transaction
            session.beginTransaction();

            //3. Get StudentId (as an example Id: 1)
            Integer studentId = 1;
            Student student = session.get(Student.class, studentId);

            //4. We update object.
            System.out.println("Updating student...");
            student.setFirstName("Scooby");

            //5. commit transaction to save it and update in DB
            session.getTransaction().commit();


            session = factory.getCurrentSession();
            session.beginTransaction();

            session.createQuery("update Student set email='foo@gmail.com'").executeUpdate();

            session.getTransaction().commit();

        } finally {
            factory.close();
        }
    }
}
