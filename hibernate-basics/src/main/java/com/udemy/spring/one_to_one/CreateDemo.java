package com.udemy.spring.one_to_one;

import com.udemy.spring.one_to_one.model.Instructor;
import com.udemy.spring.one_to_one.model.InstructorDetail;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 * @author alexander.shakhov on 11.05.2018 13:26
 */
public class CreateDemo {

    public static void main(String[] args) {
        //create session factory
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Instructor.class)
                .addAnnotatedClass(InstructorDetail.class)
                .buildSessionFactory();

        //create session
        Session session = factory.getCurrentSession();

        try {
            // 0. Prepare objects.
            Instructor instructor = new Instructor("Chad", "Darby", "darby@luv@code.com");
            InstructorDetail instructorDetail = new InstructorDetail("https://www.luv2code.com/youtube", "coding");

            // 1. Associate the objects.
            instructor.setInstructorDetail(instructorDetail);

            //start transaction
            session.beginTransaction();
            /*
            * This will save instructor and associated objects
            * because of CascadeType.ALL.
            * */
            System.out.println("Saving Instructor: " + instructor);
            session.save(instructor);

            //commit transaction
            session.getTransaction().commit();

        } finally {
            factory.close();
        }
    }
}
