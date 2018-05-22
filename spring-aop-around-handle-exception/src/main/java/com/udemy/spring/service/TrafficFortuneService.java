package com.udemy.spring.service;

import org.springframework.stereotype.Component;

import java.util.concurrent.TimeUnit;

/**
 * @author alexander.shakhov on 22.05.2018 11:06
 */
@Component
public class TrafficFortuneService {
	public String getFortune() {
		//simulate delay
		try {
			TimeUnit.SECONDS.sleep(5);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		//return fortune
		return "Expect heavy traffic this morning";
	}

	public String getFortune(boolean tripWire) {
		if(tripWire) {
			throw new RuntimeException("Major accident! Highway is closed!");
		}
		return getFortune();
	}
}
