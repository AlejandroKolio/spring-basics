package com.udemy.spring.configuration;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

/**
 * @author alexander.shakhov on 18.05.2018 18:08
 */
@Configuration
@EnableAspectJAutoProxy
@ComponentScan("com.udemy.spring")
public class ConfigAop {



}
