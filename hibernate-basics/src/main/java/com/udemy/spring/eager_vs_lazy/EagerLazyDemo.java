package com.udemy.spring.eager_vs_lazy;

import com.udemy.spring.eager_vs_lazy.model.Course;
import com.udemy.spring.eager_vs_lazy.model.Instructor;
import com.udemy.spring.eager_vs_lazy.model.InstructorDetail;
import lombok.extern.log4j.Log4j;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 * @author alexander.shakhov on 11.05.2018 13:26
 * @project spring-basics
 * @description
 */
@Log4j
public class EagerLazyDemo {

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

        try {

            //start transaction
            session.beginTransaction();

            // 1. Get Instructor from DB
            Instructor instructor = session.get(Instructor.class, 1);

            log.info("INSTRUCTOR: " + instructor);
            log.info("COURSES: " + instructor.getCourses());

            //commit transaction
            session.getTransaction().commit();

            // !NB We close it purposely to check LAZY and EAGER.
            session.close();

            log.info("SESSION: " + session.getSession());

            /*
             * Get all the Instructor courses.
             * It's available even if the session is closed due to FetchType.LAZY.
             * */
            log.info("COURSES: " + instructor.getCourses());

        } finally {
            factory.close();
        }
    }
}
