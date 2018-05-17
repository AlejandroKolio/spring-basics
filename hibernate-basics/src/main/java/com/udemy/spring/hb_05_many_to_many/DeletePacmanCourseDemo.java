package com.udemy.spring.hb_05_many_to_many;

import com.udemy.spring.hb_05_many_to_many.model.*;
import lombok.extern.log4j.Log4j;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

@Log4j
public class DeletePacmanCourseDemo {

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

			// get the pacman course from db
			int courseId = 10;
			Course tempCourse = session.get(Course.class, courseId);

			// delete the course
			log.info("DELETING COURSE: " + tempCourse);

			session.delete(tempCourse);

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





