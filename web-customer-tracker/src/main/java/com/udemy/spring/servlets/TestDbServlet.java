package com.udemy.spring.servlets;

import lombok.extern.log4j.Log4j;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;

/**
 * @author alexander.shakhov on 17.05.2018 12:23
 */
@Log4j
@WebServlet("/TestDbServlet")
public class TestDbServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String user     = "springstudent";
        String pass     = "springstudent";
        String jdbcUrl  = "jdbc:mysql://localhost:3306/web_customer_tracker?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC&useSSL=false";
        String driver   = "com.mysql.jdbc.Driver";

        PrintWriter writer = response.getWriter();
        try {
            writer.println("CONNECTING TO:   \t" + jdbcUrl);
            Class.forName(driver);
            Connection connection = DriverManager.getConnection(jdbcUrl, user, pass);
            writer.println("SUCCESS! DB NAME:\t" + connection.getCatalog());
        } catch (Exception e) {
            writer.println("FAIL: " + e.getMessage());
            e.printStackTrace();
            throw new ServletException(e);
        }
    }
}
