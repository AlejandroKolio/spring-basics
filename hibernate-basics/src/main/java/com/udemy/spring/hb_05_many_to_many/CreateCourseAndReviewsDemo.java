package com.udemy.spring.hb_05_many_to_many;

import com.udemy.spring.hb_05_many_to_many.model.Course;
import com.udemy.spring.hb_05_many_to_many.model.Instructor;
import com.udemy.spring.hb_05_many_to_many.model.InstructorDetail;
import com.udemy.spring.hb_05_many_to_many.model.Review;
import com.udemy.spring.hb_05_many_to_many.model.Student;
import lombok.extern.log4j.Log4j;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

@Log4j
public class CreateCourseAndReviewsDemo {

	public static void main(String[] args) {

		// create session factory
		SessionFactory factory = new Configuration()
								.configure("hibernate.cfg.xml")
								.addAnnotatedClass(Instructor.class)
								.addAnnotatedClass(InstructorDetail.class)
								.addAnnotatedClass(Course.class)
								.addAnnotatedClass(Review.class)
								.addAnnotatedClass(Student.class)
								.buildSessionFactory();
		
		// create session
		Session session = factory.getCurrentSession();
		
		try {			
			
			// start a transaction
			session.beginTransaction();
			
			
			// create a course
			Course course = new Course("Pacman - How To Score One Million Points");
			
			// add some reviews
			course.addReview(new Review("Great course ... loved it!"));
			course.addReview(new Review("Cool course, job well done"));
			course.addReview(new Review("What a dumb course, you are an idiot!"));
						

			log.info("SAVING THE COURSE:\t" + course);
			log.info("REVIEWS: 		    \t" + course.getReviews());

			// save the course ... and leverage the cascade all :-)
			session.save(course);
			
			// commit transaction
			session.getTransaction().commit();
			
			log.info("DONE!");
		} catch (Exception e) {
			session.close();
			log.error("ERROR: " + e.getMessage());
			e.printStackTrace();
		} finally {
			
			// add clean up code
			session.close();
			
			factory.close();
		}
	}

}





