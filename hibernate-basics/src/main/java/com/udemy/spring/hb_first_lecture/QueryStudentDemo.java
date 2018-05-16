package com.udemy.spring.hb_first_lecture;

import com.udemy.spring.hb_first_lecture.entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;

/**
 * @author alexander.shakhov on 11.05.2018 13:26
 * @project spring-basics
 * @description
 */
public class QueryStudentDemo {

    public static void main(String[] args) {
        //create session factory
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Student.class)
                .buildSessionFactory();

        //create session
        Session session = factory.getCurrentSession();

        try {
            //1. Start Transaction.
            System.out.println("Start transaction");
            session.beginTransaction();

            //2. Display All the Students.
            System.out.println("Display students");

            //2.1 All the Students
            List<Student> listOfAllStudents          = session.createQuery("from Student").getResultList();
            displayStudent(listOfAllStudents);

            //2.2 Last Name Doe
            List<Student> listStudentWithDoeLastName = session.createQuery("from Student s where s.lastName='Doe'").getResultList();
            displayStudent(listStudentWithDoeLastName);

            //2.3 Last Name Doe or Name Daffy
            List<Student> doeOrDuffy                 = session.createQuery("from Student s where s.lastName='Doe' or s.firstName='Daffy'").getResultList();
            displayStudent(doeOrDuffy);

            //2.4 Email LIKE luv2code.com
            List<Student> emailList                  = session.createQuery("from Student s where s.email like '%luv2code.com'").getResultList();
            displayStudent(emailList);

            //3. Commit transaction.
            System.out.println("Done!");
            session.getTransaction().commit();

        } finally {
            factory.close();
        }
    }

    private static void displayStudent(List<Student> students) {
        students.forEach(System.out::println);
        System.out.println("\n");
    }
}
