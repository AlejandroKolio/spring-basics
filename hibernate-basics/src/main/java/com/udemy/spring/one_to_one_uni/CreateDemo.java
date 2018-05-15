package com.udemy.spring.one_to_one_uni;

import com.udemy.spring.one_to_one_uni.model.Instructor;
import com.udemy.spring.one_to_one_uni.model.InstructorDetail;
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
            Instructor instructorChad = new Instructor("Chad", "Darby", "darby@luv@code.com");
            Instructor instructorMadu = new Instructor("Madu", "Picaboo", "madu@luv@code.com");
            InstructorDetail chadDetail = new InstructorDetail("https://www.luv2code.com/youtube", "coding");
            InstructorDetail maduDetail = new InstructorDetail("https://www.youtube.com", "guitar");

            // 1. Associate the objects.
            instructorMadu.setInstructorDetail(maduDetail);

            //start transaction
            session.beginTransaction();
            /*
            * This will save instructorChad and associated objects
            * because of CascadeType.ALL.
            * */
            System.out.println("Saving Instructor: " + instructorMadu);
            session.save(instructorMadu);

            //commit transaction
            session.getTransaction().commit();

        } finally {
            factory.close();
        }
    }
}
