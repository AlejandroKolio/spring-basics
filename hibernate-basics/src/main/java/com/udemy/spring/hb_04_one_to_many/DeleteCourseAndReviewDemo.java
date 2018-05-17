package com.udemy.spring.hb_04_one_to_many;

import com.udemy.spring.hb_04_one_to_many.model.Course;
import com.udemy.spring.hb_04_one_to_many.model.Instructor;
import com.udemy.spring.hb_04_one_to_many.model.InstructorDetail;
import com.udemy.spring.hb_04_one_to_many.model.Review;
import lombok.extern.log4j.Log4j;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 * @author alexander.shakhov on 11.05.2018 13:26
 */
@Log4j
public class DeleteCourseAndReviewDemo {

    public static void main(String[] args) {
        //create session factory
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Instructor.class)
                .addAnnotatedClass(InstructorDetail.class)
                .addAnnotatedClass(Course.class)
                .addAnnotatedClass(Review.class)
                .buildSessionFactory();

        //create session
        Session session = factory.getCurrentSession();

        try {
            //start transaction
            session.beginTransaction();

            // 1. Get Course with id 1
            Course course = session.get(Course.class, 13);

            log.info("DELETE COURSE: " + course);
            session.delete(course);

            log.info("REVIEW: " + course.getReviews());

            //commit transaction
            session.getTransaction().commit();

        } finally {
            factory.close();
        }
    }
}
