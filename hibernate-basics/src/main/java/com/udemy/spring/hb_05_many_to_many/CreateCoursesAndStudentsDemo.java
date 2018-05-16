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

/**
 * @author alexander.shakhov on 11.05.2018 13:26
 */
@Log4j
public class CreateCoursesAndStudentsDemo {

    public static void main(String[] args) {
        //create session factory
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Instructor.class)
                .addAnnotatedClass(InstructorDetail.class)
                .addAnnotatedClass(Course.class)
                .addAnnotatedClass(Review.class)
                .addAnnotatedClass(Student.class)
                .buildSessionFactory();

        //create session
        Session session = factory.getCurrentSession();

        try {
            //start transaction
            session.beginTransaction();

            // 0. Create Course
            Course course = new Course("Pacman - How to score one million points");

            log.info("SAVING COURSE: " + course);
            session.save(course);

            // 1. Create Student
            Student john = new Student("John", "Doe", "joh,doe@luv2code.com");
            Student mary = new Student("Mary", "Public", "mary,public@luv2code.com");

            // 2. Add Students to the Course
            course.addStudent(john);
            course.addStudent(mary);

            // 3. Save the Students
            log.info("SAVING THE STUDENT: " + john);
            session.save(john);
            log.info("SAVING THE STUDENT: " + mary);
            session.save(mary);

            // 4. Get All Saved Students.
            log.info("SAVED STUDENTS: " + course.getStudents());

            //commit transaction
            session.getTransaction().commit();

        } finally {
            factory.close();
        }
    }
}
