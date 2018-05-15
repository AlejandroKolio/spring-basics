package com.udemy.spring;

import com.udemy.spring.entity.Student;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 * @author alexander.shakhov on 10.05.2018 16:19
 */
public class TestJdbc {
    public static void main(String[] args) {
        /*
        * Standard url from tutorial fail with exception java.sql.SQLException: The server timezone value 'UTC' is unrecognized or represents more than one timezone.
        * Found solution here https://stackoverflow.com/questions/26515700/mysql-jdbc-driver-5-1-33-time-zone-issue
        *
        * So URL is update with timezone configurations.
        * */
        String hbStudentTrackerUrl = "jdbc:mysql://localhost:3306/hb_student_tracker?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC&useSSL=false";
        String hb01OneToOneUniUrl = "jdbc:mysql://localhost:3306/hb-01-one-to-one-uni?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC&useSSL=false";

        String user = "hbstudent";
        String pass = "hbstudent";

        try {
            System.out.println("Connecting to database: " + hb01OneToOneUniUrl);

            Connection myConn = DriverManager.getConnection(hb01OneToOneUniUrl, user, pass);

            System.out.println("Connection successful!!! " + myConn.getCatalog());

        }
        catch (Exception exc) {
            exc.printStackTrace();
        }
    }
}
