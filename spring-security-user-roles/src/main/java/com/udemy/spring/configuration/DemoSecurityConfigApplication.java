package com.udemy.spring.configuration;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;

/**
 * @author alexander.shakhov on 23.05.2018 15:09
 */
@Configuration
@EnableWebSecurity
public class DemoSecurityConfigApplication extends WebSecurityConfigurerAdapter {

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		// 1. Add our users for in memory authentication.

		User.UserBuilder users = User.withDefaultPasswordEncoder();

		auth.inMemoryAuthentication()
				.withUser(users.username("john").password("test123").roles("EMPLOYEE"))
				.withUser(users.username("mary").password("test123").roles("EMPLOYEE","MANAGER"))
				.withUser(users.username("susan").password("test123").roles("EMPLOYEE","ADMIN"));
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests()
				.antMatchers("/").hasRole("EMPLOYEE")
				.antMatchers("/leaders/**").hasRole("MANAGER")
				.antMatchers("/systems/**").hasRole("ADMIN")
				.and()
				.formLogin()
				.loginPage("/login")
				.loginProcessingUrl("/authenticateUser")
				.permitAll()
				.and()
				.logout().permitAll()
				.and()
				.exceptionHandling()
				.accessDeniedPage("/access-denied");
	}
}
