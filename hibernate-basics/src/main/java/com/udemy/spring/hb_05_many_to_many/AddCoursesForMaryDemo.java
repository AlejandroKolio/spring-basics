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
public class AddCoursesForMaryDemo {

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
				
			// get the student mary from database
			int studentId = 2;
			Student student = session.get(Student.class, studentId);

			log.info("\nLOADED STUDENT: " + student);
			log.info("COURSES: " + student.getCourses());
			
			// create more courses 
			Course course1 = new Course("Rubik's Cube - How to Speed Cube");
			Course course2 = new Course("Atari 2600 - Game Development");
						
			// add student to courses
			course1.addStudent(student);
			course2.addStudent(student);
						
			// save the courses
			log.info("\nSAVING THE COURSES ...");
			
			session.save(course1);
			session.save(course2);
						
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





