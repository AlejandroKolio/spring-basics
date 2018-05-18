package com.udemy.spring.service;

import com.udemy.spring.entity.Customer;

import java.util.List;

/**
 * @author alexander.shakhov on 18.05.2018 11:01
 * @project spring-basics
 * @description
 */
public interface CustomerService {

    List<Customer> getCustomers();

    void saveCustomer(Customer customer);

    Customer getCustomer(Integer id);

    void deleteCustomer(Integer id);

    List<Customer> searchCustomers(String searchName);

}
