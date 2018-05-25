package com.udemy.spring.rest;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author alexander.shakhov on 25.05.2018 19:20
 */
@RestController
@RequestMapping("/restful")
public class MyRestController {

	@RequestMapping("/hello")
	public String sayHello() {
		return "Hello World!";
	}

}
