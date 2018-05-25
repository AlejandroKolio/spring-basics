package com.udemy.spring.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @author alexander.shakhov on 25.05.2018 13:12
 */
@Data
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class Student {

	private Integer id;
	private String firstName;
	private String lastName;
	private Boolean active;
	private Address address;
	private List<String> languages;
}
