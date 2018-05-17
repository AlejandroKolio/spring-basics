package com.udemy.spring.dao;

import com.udemy.spring.entity.Customer;

import java.util.List;

/**
 * @author alexander.shakhov on 17.05.2018 17:02
 */
public interface CustomerDao {

    List<Customer> getCustomers();

}
