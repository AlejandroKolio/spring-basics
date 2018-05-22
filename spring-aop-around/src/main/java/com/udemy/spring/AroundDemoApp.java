package com.udemy.spring;

import com.udemy.spring.config.ConfigApp;
import com.udemy.spring.dao.AccountDao;
import com.udemy.spring.model.Account;
import com.udemy.spring.service.TrafficFortuneService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;

public class AroundDemoApp {

	public static void main(String[] args) {

		// read spring config java class
		AnnotationConfigApplicationContext context =
				new AnnotationConfigApplicationContext(ConfigApp.class);

		// get the bean from spring container
		TrafficFortuneService trafficFortuneService =
				context.getBean("trafficFortuneService", TrafficFortuneService.class);

		System.out.println("\nMain Program: AroundDemoApp");
		System.out.println("\nCalling getFortune");

		String fortune = trafficFortuneService.getFortune();

		System.out.println("\nMy fortune is: " + fortune);

		System.out.println("Finished!");

		// close the context
		context.close();
	}

}










