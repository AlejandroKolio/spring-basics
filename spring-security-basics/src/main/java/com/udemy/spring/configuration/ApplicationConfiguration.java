package com.udemy.spring.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

/**
 * @author alexander.shakhov on 23.05.2018 13:54
 */
@Configuration
@EnableWebMvc // same as  <mvc:annotation-driven/>
@ComponentScan(basePackages = "com.udemy.spring") // same as <context:component-scan base-package="com.udemy.spring"/>
public class ApplicationConfiguration {

	// 1. Define bean for ViewResolver
	@Bean
	public ViewResolver viewResolver() {
		InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
		viewResolver.setPrefix("/WEB-INF/view/");
		viewResolver.setSuffix(".jsp");

		return viewResolver;
	}
}
