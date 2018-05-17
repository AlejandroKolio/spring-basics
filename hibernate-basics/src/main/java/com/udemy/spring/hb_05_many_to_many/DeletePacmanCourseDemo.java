package com.udemy.spring.hb_05_many_to_many;

import com.udemy.spring.hb_05_many_to_many.model.Course;
import com.udemy.spring.hb_05_many_to_many.model.Instructor;
import com.udemy.spring.hb_05_many_to_many.model.InstructorDetail;
import com.udemy.spring.hb_05_many_to_many.model.Review;
import com.udemy.spring.hb_05_many_to_many.model.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


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
			int courseId = 20;
			Course tempCourse = session.get(Course.class, courseId);
			
			// delete the course
			System.out.println("DELETING COURSE: " + tempCourse);
			
			session.delete(tempCourse);
						
			// commit transaction
			session.getTransaction().commit();
			
			System.out.println("DONE!");
		}
		finally {
			
			// add clean up code
			session.close();
			
			factory.close();
		}
	}

}





