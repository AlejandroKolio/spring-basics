package com.udemy.spring;

import com.udemy.app.model.FootballCoach;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class PracticeHelloSpringApp {

	public static void main(String[] args) {

		// load the spring configuration file
		AnnotationConfigApplicationContext context =
				new AnnotationConfigApplicationContext(ConfigurationApp.class);
				
		// get the bean from spring container
		FootballCoach theCoach = context.getBean("footballCoach", FootballCoach.class);

		// call a method on the bean
		System.out.println(theCoach.getDailyWorkout());
				
		// call method to get the daily fortune
		System.out.println(theCoach.getDailyFortune());
			
		// call our new swim coach methods ... has the props values injected
		System.out.println("email: " + theCoach.getEmail());
		System.out.println("team: " + theCoach.getTeam());
		
		// close the context
		context.close();
	}

}







