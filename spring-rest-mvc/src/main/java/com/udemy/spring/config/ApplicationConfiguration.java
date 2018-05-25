package com.udemy.spring.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

/**
 * @author alexander.shakhov on 25.05.2018 19:08
 */

@EnableWebMvc
@Configuration
@ComponentScan(basePackages = "com.udemy.spring")
public class ApplicationConfiguration {

}
