package com.udemy.spring;

import com.udemy.spring.configuration.ConfigApp;
import com.udemy.spring.service.TrafficFortuneService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class AroundDemoApp {

	public static void main(String[] args) {

		// read spring configuration java class
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










