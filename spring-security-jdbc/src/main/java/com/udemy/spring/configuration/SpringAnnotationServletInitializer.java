package com.udemy.spring.configuration;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

/**
 * @author alexander.shakhov on 23.05.2018 14:05
 *
 * @description: This class is to replace web.xml
 */
public class SpringAnnotationServletInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {

	@Override
	protected Class<?>[] getRootConfigClasses() {
		return null;
	}

	/**
	 * Replace <servlet> section of web.xml file.
	 * */
	@Override
	protected Class<?>[] getServletConfigClasses() {
		return new Class[]{ApplicationConfiguration.class};
	}

	/**
	 * Replace <servlet-mapping> section of web.xml file.
	 * */
	@Override
	protected String[] getServletMappings() {
		return new String[]{"/"};
	}
}
