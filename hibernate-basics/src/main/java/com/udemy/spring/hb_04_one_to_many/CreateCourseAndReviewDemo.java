package com.udemy.spring.hb_04_one_to_many;

import com.udemy.spring.hb_04_one_to_many.model.Course;
import com.udemy.spring.hb_04_one_to_many.model.Review;
import com.udemy.spring.hb_04_one_to_many.model.Instructor;
import com.udemy.spring.hb_04_one_to_many.model.InstructorDetail;
import lombok.extern.log4j.Log4j;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 * @author alexander.shakhov on 11.05.2018 13:26
 */
@Log4j
public class CreateCourseAndReviewDemo {

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

            Course course = new Course("Pacman - How to score one million points");

            course.addReview(new Review("Nice try!"));
            course.addReview(new Review("Cool course..."));
            course.addReview(new Review("Job well!"));
            course.addReview(new Review("It's dumb course, you are an idiot!?"));

            log.info("SAVE COURSE: " + course);
            log.info("GET REVIEWS: " + course.getReviews());
            session.save(course);

            //commit transaction
            session.getTransaction().commit();

        } finally {
            factory.close();
        }
    }
}
