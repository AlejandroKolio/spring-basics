package com.udemy.spring;

import com.udemy.spring.model.Coach;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class PracticeHelloSpringApp {

	public static void main(String[] args) {

		// load the spring configuration file
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		//ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("beanScopeContext.xml");

		// retrieve bean from spring container
		//Coach golfCoach = context.getBean("myGolfCoach", Coach.class);
		Coach pingPongCoach = context.getBean("pingPongCoach", Coach.class);

		// call methods on the bean
		//System.out.println(golfCoach.getDailyWorkout());

		System.out.println(pingPongCoach.getDailyFortune());

		// close the context
		context.close();
	}

}







