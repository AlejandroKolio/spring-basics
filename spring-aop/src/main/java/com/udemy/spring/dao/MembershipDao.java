package com.udemy.spring.dao;

import org.springframework.stereotype.Component;

/**
 * @author alexander.shakhov on 18.05.2018 18:55
 */
@Component
public class MembershipDao {

	public void addAccount() {
		System.out.println(getClass() + ": DOING STUFF: ADDING A MEMBERSHIP ACCOUNT");
	}

}
