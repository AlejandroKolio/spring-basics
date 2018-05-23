package com.udemy.spring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author alexander.shakhov on 23.05.2018 17:31
 * @project spring-basics
 * @description
 */
@Controller
public class LoginController {

	@GetMapping("/login")
	public String login() {
		return "login";
	}
}
