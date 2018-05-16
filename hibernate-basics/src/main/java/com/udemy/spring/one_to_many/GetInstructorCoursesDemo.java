package com.udemy.spring.one_to_many;

import com.udemy.spring.one_to_many.model.Course;
import com.udemy.spring.one_to_many.model.Instructor;
import com.udemy.spring.one_to_many.model.InstructorDetail;
import lombok.extern.log4j.Log4j;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;

/**
 * @author alexander.shakhov on 11.05.2018 13:26
 * @project spring-basics
 * @description
 */
@Log4j
public class GetInstructorCoursesDemo {

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

            // 2. Get all the Instructor courses.
            List<Course> courses = instructor.getCourses();
            log.info("Courses: " + courses);

            //commit transaction
            session.getTransaction().commit();

        } finally {
            factory.close();
        }
    }
}
