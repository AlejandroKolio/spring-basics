package com.udemy.spring.config;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

/**
 * @author alexander.shakhov on 25.05.2018 19:13
 */
public class SpringMvcDispatcherServletInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {

	@Override
	protected Class<?>[] getRootConfigClasses() {
		return null;
	}

	@Override
	protected Class<?>[] getServletConfigClasses() {
		return new Class[]{ ApplicationConfiguration.class };
	}

	@Override
	protected String[] getServletMappings() {
		return new String[]{ "/" };
	}
}
