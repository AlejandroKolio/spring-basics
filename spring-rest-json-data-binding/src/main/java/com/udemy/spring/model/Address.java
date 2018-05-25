package com.udemy.spring.model;

import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author alexander.shakhov on 25.05.2018 15:05
 */
@Data
@NoArgsConstructor
public class Address {

	private String street;
	private String city;
	private String state;
	private String zip;
	private String country;
}
