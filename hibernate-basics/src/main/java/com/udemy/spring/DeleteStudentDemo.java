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
public class DeleteStudentDemo {

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

            //4. Delete student
            System.out.println(student.getFirstName() + " " + student.getLastName());
            session.delete(student);

            //5. commit transaction
            System.out.println("Done");
            session.getTransaction().commit();

        } finally {
            factory.close();
        }
    }
}
