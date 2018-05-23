package com.udemy.spring;

import com.udemy.spring.configuration.ConfigApp;
import com.udemy.spring.dao.AccountDao;
import com.udemy.spring.model.Account;
import java.util.List;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class AfterReturningDemoApp {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(ConfigApp.class);

        AccountDao accountDao = context.getBean("accountDao", AccountDao.class);

        List<Account> accounts = accountDao.findAccounts();

        System.out.println("\n\nMain: AfterReturningDemoApp");
        System.out.println("-------------------------------");

        accounts.forEach(System.out::println);

        System.out.println("\n");

        context.close();
    }
}
