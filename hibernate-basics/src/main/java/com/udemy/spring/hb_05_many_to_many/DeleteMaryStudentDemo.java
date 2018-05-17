package com.udemy.spring.hb_05_many_to_many;

import com.udemy.spring.hb_05_many_to_many.model.*;
import lombok.extern.log4j.Log4j;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

@Log4j
public class DeleteMaryStudentDemo {

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

			// get the student from database
			int studentId = 2;
			Student tempStudent = session.get(Student.class, studentId);

			log.info("LOADED STUDENT:	\t" + tempStudent);
			log.info("COURSES: 		 	\t" + tempStudent.getCourses());

			// delete student
			log.info("DELETING STUDENT: " + tempStudent);
			session.delete(tempStudent);

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





