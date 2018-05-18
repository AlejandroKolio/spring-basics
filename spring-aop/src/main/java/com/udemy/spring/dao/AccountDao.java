package com.udemy.spring.dao;

import org.springframework.stereotype.Component;

/**
 * @author alexander.shakhov on 18.05.2018 18:07
 */
@Component
public class AccountDao {

	public void addAccount() {
		System.out.println(getClass() + ": DOING MY DB WORK: ADDING AND ACCOUNT");
	}
}
