package com.udemy.spring.dao;

import com.udemy.spring.model.Account;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

@Component
public class AccountDao {

	private String name;
	private String serviceCode;
	
	public void addAccount(Account account, boolean isVIP) {
		System.out.println(getClass() + ": DOING MY DB WORK: ADDING AN ACCOUNT");
	}

	public List<Account> findAccounts(boolean tripWire) {

		if (tripWire) {
			throw new RuntimeException("No soup for you!!!");
		}
		return Arrays.asList(
				new Account("John", "Silver"),
				new Account("Madu", "Platinum"),
				new Account("Luca", "Gold"));
	}
	
	public boolean doWork() {
		System.out.println(getClass() + ": doWork()");
		return false;
	}

	public String getName() {
		System.out.println(getClass() + ": in getName()");
		return name;
	}

	public void setName(String name) {
		System.out.println(getClass() + ": in setName()");
		this.name = name;
	}

	public String getServiceCode() {
		System.out.println(getClass() + ": in getServiceCode()");
		return serviceCode;
	}

	public void setServiceCode(String serviceCode) {
		System.out.println(getClass() + ": in setServiceCode()");
		this.serviceCode = serviceCode;
	}
	
	
	
}





