package com.udemy.spring.hb_01_one_to_one_uni;

import com.udemy.spring.hb_01_one_to_one_uni.model.Instructor;
import com.udemy.spring.hb_01_one_to_one_uni.model.InstructorDetail;
import lombok.extern.log4j.Log4j;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 * @author alexander.shakhov on 11.05.2018 13:26
 */
@Log4j
public class DeleteDemo {

    public static void main(String[] args) {
        //create session factory
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Instructor.class)
                .addAnnotatedClass(InstructorDetail.class)
                .buildSessionFactory();

        //create session
        Session session = factory.getCurrentSession();

        try {

            //start transaction
            session.beginTransaction();

            Integer instructorId = 1;
            Instructor instructor = session.get(Instructor.class, instructorId);

            log.info("Instructor: " + instructor.getFirstName() + " " + instructor.getLastName() + " found");
            if (instructor != null) {
                log.info("Deleting " + instructor.getId());
                session.delete(instructor);
            }

            //commit transaction
            session.getTransaction().commit();

            log.info("Done!");

        } finally {
            factory.close();
        }
    }
}
