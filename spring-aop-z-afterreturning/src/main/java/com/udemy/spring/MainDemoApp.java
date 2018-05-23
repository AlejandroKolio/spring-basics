package com.udemy.spring;

import com.udemy.spring.configuration.ConfigApp;
import com.udemy.spring.dao.AccountDao;
import com.udemy.spring.dao.MembershipDao;
import com.udemy.spring.model.Account;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MainDemoApp {

    public static void main(String[] args) {

        // read com.udemy.spring.spring configuration java class
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(ConfigApp.class);

        // get the bean from com.udemy.spring.spring container
        AccountDao accountDao = context.getBean("accountDao", AccountDao.class);

        // get membership bean from com.udemy.spring.spring container
        MembershipDao theMembershipDAO =
                context.getBean("membershipDao", MembershipDao.class);

        // call the business method
        Account account = new Account();
        account.setName("Madhu");
        account.setLevel("Platinum");

        accountDao.addAccount(account, true);
        accountDao.doWork();

        // call the accountdao getter/setter methods
        accountDao.setName("foobar");
        accountDao.setServiceCode("silver");

        String name = accountDao.getName();
        String code = accountDao.getServiceCode();

        // call the membership business method
        theMembershipDAO.addSillyMember();
        theMembershipDAO.goToSleep();

        // close the context
        context.close();
    }

}










