package com.udemy.spring.hb_03_one_to_many;

import com.udemy.spring.hb_03_one_to_many.model.Course;
import com.udemy.spring.hb_03_one_to_many.model.Instructor;
import com.udemy.spring.hb_03_one_to_many.model.InstructorDetail;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 * @author alexander.shakhov on 11.05.2018 13:26
 * @project com.udemy.spring.spring-basics
 * @description
 */
public class CreateInstructorDemo {

    public static void main(String[] args) {
        //create session factory
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Instructor.class)
                .addAnnotatedClass(InstructorDetail.class)
                .addAnnotatedClass(Course.class)
                .buildSessionFactory();

        //create session
        Session session = factory.getCurrentSession();

        try{
            //create object
            Instructor instructor =
                    new Instructor("Susan", "Public", "susan.public@luv@code.com");
            InstructorDetail instructorDetail =
                    new InstructorDetail("https://www.youtube.com", "Video Games");

            // associate the objects
            instructor.setInstructorDetail(instructorDetail);

            //start transaction
            session.beginTransaction();

            //save object
            session.save(instructor);

            //commit transaction
            session.getTransaction().commit();

        } finally {
            factory.close();
        }
    }
}
