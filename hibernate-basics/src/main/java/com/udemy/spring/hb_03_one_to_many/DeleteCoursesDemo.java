package com.udemy.spring.hb_03_one_to_many;

import com.udemy.spring.hb_03_one_to_many.model.Course;
import com.udemy.spring.hb_03_one_to_many.model.Instructor;
import com.udemy.spring.hb_03_one_to_many.model.InstructorDetail;
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
public class DeleteCoursesDemo {

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

            // 1. Get Course from DB
            Course course = session.get(Course.class, 13);

            // 2. Delete Course
            log.info("Course: '" + course.getTitle() + "' deleted");
            session.delete(course);

            //commit transaction
            session.getTransaction().commit();
        } catch (Exception e) {
            session.close();
            e.printStackTrace();
        } finally {
            factory.close();
        }
    }
}
