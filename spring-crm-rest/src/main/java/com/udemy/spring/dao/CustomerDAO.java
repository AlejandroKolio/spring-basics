package com.udemy.spring.dao;

import com.udemy.spring.entity.Customer;

import java.util.List;

/**
 * @author alexander.shakhov on 28.05.2018 13:21
 */

public interface CustomerDAO {

	List<Customer> getCustomers();

	void saveCustomer(Customer customer);

	Customer getCustomer(Integer id);

	void deleteCustomer(Integer id);

}
