package com.udemy.spring.one_to_many;

import com.udemy.spring.one_to_many.model.Course;
import com.udemy.spring.one_to_many.model.Instructor;
import com.udemy.spring.one_to_many.model.InstructorDetail;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 * @author alexander.shakhov on 11.05.2018 13:26
 * @project spring-basics
 * @description
 */
public class CreateCourseDemo {

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

            // 2. Create course
            Course hibernateCourse = new Course("Hibernate for 30 days");
            Course airGuitar = new Course("Air Guitar - The Ultimate Guide");
            Course pinBall = new Course("The Pinball Masterclass");

            // 3. Add this course to Instructor
            instructor.addCourse(hibernateCourse);
            instructor.addCourse(airGuitar);
            instructor.addCourse(pinBall);

            // 4. Save course (object) to DB
            session.save(hibernateCourse);
            session.save(airGuitar);
            session.save(pinBall);

            //commit transaction
            session.getTransaction().commit();

        } finally {
            factory.close();
        }
    }
}
