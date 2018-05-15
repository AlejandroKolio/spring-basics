package com.udemy.spring.one_to_one_bi;

import com.udemy.spring.one_to_one_bi.model.Instructor;
import com.udemy.spring.one_to_one_bi.model.InstructorDetail;
import lombok.extern.log4j.Log4j;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 * @author alexander.shakhov on 11.05.2018 13:26
 */
@Log4j
public class GetInstructorDetailDemo {

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
            // start a transaction
            session.beginTransaction();

            // get the instructor detail object
            int theId = 2;
            InstructorDetail tempInstructorDetail =
                    session.get(InstructorDetail.class, theId);

            // print the instructor detail
            log.info("tempInstructorDetail: " + tempInstructorDetail);

            // print  the associated instructor
            log.info("the associated instructor: " + tempInstructorDetail.getInstructor());

            // commit transaction
            session.getTransaction().commit();

            log.info("Done!");

        } finally {
            factory.close();
        }
    }
}
