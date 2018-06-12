package com.udemy.spring.controller;

import com.udemy.spring.entity.Customer;
import com.udemy.spring.exception.UserNotFoundException;
import com.udemy.spring.service.CustomerService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author alexander.shakhov on 28.05.2018 13:43
 * @project spring-basics
 * @description
 */
@RestController
@RequestMapping("/api")
public class CustomerRestController {

    @Autowired
    private CustomerService customerService;

    @GetMapping("/customers")
    public List<Customer> getCustomers() {
        return customerService.getCustomers();
    }

    @GetMapping("/customer/{id}")
    public Customer getCustomer(@PathVariable Integer id) {

        Customer customer = customerService.getCustomer(id);

        if (customer == null) {
            throw new UserNotFoundException("Customer id not found - " + id);
        }

        return customer;
    }

    @PostMapping("/customers")
    public Customer addCustomer(@RequestBody Customer customer) {

        customer.setId(0);

        customerService.saveOrUpdateCustomer(customer);

        return customer;
    }

    @PutMapping("/customers")
    public Customer updateCustomer(@RequestBody Customer customer) {

        customerService.saveOrUpdateCustomer(customer);

        return customer;
    }

    @DeleteMapping("/customer/{id}")
    public String deleteCustomer(@PathVariable Integer id) {

        Customer customer = customerService.getCustomer(id);

        if(customer == null) {
            throw new UserNotFoundException("Customer id not found - " + id);
        }

        customerService.deleteCustomer(id);

        return "Deleted customer id - " + id;
    }

}
