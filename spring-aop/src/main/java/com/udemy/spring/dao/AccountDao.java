package com.udemy.spring.dao;

import com.udemy.spring.model.Account;
import org.springframework.stereotype.Component;

/**
 * @author alexander.shakhov on 18.05.2018 18:07
 */
@Component
public class AccountDao {

	public void addAccount(Account account, boolean flag) {
		System.out.println(getClass() + ": DOING MY DB WORK: ADDING AND ACCOUNT");
	}

	public boolean doWork() {

		System.out.println(getClass() + ": doWork()");
		return false;
	}
}
