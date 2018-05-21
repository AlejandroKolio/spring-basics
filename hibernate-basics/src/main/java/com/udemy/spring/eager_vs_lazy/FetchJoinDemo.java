package com.udemy.spring.eager_vs_lazy;

import com.udemy.spring.eager_vs_lazy.model.Course;
import com.udemy.spring.eager_vs_lazy.model.Instructor;
import com.udemy.spring.eager_vs_lazy.model.InstructorDetail;
import lombok.extern.log4j.Log4j;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

/**
 * @author alexander.shakhov on 11.05.2018 13:26
 * @project com.udemy.spring.spring-basics
 * @description
 */
@Log4j
public class FetchJoinDemo {

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

            // start a transaction
            session.beginTransaction();

            // get the instructor from db
            int theId = 1;

            Query<Instructor> query =
                    session.createQuery("select i from Instructor i "
                                    + "JOIN FETCH i.courses "
                                    + "where i.id=:instructorId",
                            Instructor.class);

            // set parameter on query
            query.setParameter("instructorId", theId);

            // execute query and get instructor
            Instructor tempInstructor = query.getSingleResult();

            log.info("INSTRUCTOR: " + tempInstructor);

            // commit transaction
            session.getTransaction().commit();

            // close the session
            session.close();

            log.info("SESSION STATUS: " + session.getSession() + "\n");

            // get courses for the instructor
            log.info("COURSES: " + tempInstructor.getCourses());

            log.info("DONE!");

        } finally {
            factory.close();
        }
    }
}
