package com.udemy.spring;

import com.udemy.spring.config.ConfigApp;
import com.udemy.spring.service.TrafficFortuneService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.logging.Logger;

public class AroundHandleExceptionDemoApp {

	private static Logger logger = Logger.getLogger(AroundHandleExceptionDemoApp.class.getName());

	public static void main(String[] args) {

		// read spring config java class
		AnnotationConfigApplicationContext context =
				new AnnotationConfigApplicationContext(ConfigApp.class);

		// get the bean from spring container
		TrafficFortuneService trafficFortuneService =
				context.getBean("trafficFortuneService", TrafficFortuneService.class);

		logger.info("\nMain Program: AroundDemoApp");
		logger.info("\nCalling getFortune");

		boolean tripWire = true;
		String fortune = trafficFortuneService.getFortune(tripWire);

		logger.info("\nMy fortune is: " + fortune);

		logger.info("Finished!");

		// close the context
		context.close();
	}

}










