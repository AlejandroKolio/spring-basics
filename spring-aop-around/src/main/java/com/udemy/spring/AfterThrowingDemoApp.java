package com.udemy.spring;

import com.udemy.spring.config.ConfigApp;
import com.udemy.spring.dao.AccountDao;
import com.udemy.spring.model.Account;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;

public class AfterThrowingDemoApp {

	public static void main(String[] args) {

		// read spring config java class
		AnnotationConfigApplicationContext context =
				new AnnotationConfigApplicationContext(ConfigApp.class);

		// get the bean from spring container
		AccountDao accountDao = context.getBean("accountDao", AccountDao.class);

		// call method to find the accounts
		List<Account> accounts = null;

		try {
			// add a boolean flag to simulate exceptions
			boolean tripWire = true;
			accounts = accountDao.findAccounts(tripWire);
		}
		catch (Exception exc) {
			System.out.println("\n\nMain Program ... caught exception: " + exc);
		}

		// display the accounts
		System.out.println("\n\nMain Program: AfterThrowingDemoApp");
		System.out.println("----");

		System.out.println(accounts);

		System.out.println("\n");

		// close the context
		context.close();
	}

}









