package com.udemy.spring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author alexander.shakhov on 23.05.2018 14:12
 */
@Controller
public class HomeController {

	@GetMapping("/")
	public String showHome() {
		return "home";
	}
}
