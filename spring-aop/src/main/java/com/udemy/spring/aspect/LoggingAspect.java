package com.udemy.spring.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

/**
 * @author alexander.shakhov on 18.05.2018 18:16
 */
@Aspect
@Component
public class LoggingAspect {

	//@Before("execution(public void *Account())")

	//@Before("execution(* add*(com.udemy.spring.model.Account, ..))")

	@Before("execution(* com.udemy.spring.dao.*.*(..))")
	public void beforeAddAccountAdvice(){
		System.out.println("\n====>>> Executing @Before advice on method");
	}
}
