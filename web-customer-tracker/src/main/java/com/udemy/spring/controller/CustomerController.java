package com.udemy.spring.controller;

import com.udemy.spring.dao.CustomerDao;
import com.udemy.spring.entity.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * @author alexander.shakhov on 17.05.2018 14:10
 */
@Controller
@RequestMapping("/customer")
public class CustomerController {

    // Need to inject customer dao
    @Autowired
    private CustomerDao customerDao;

    @RequestMapping("/list")
    public String listCustomers(Model model) {

        // 1. Get customers from DAO
        List<Customer> customers = customerDao.getCustomers();

        // 2. Add customers to the model and forward it to jsp page.
        model.addAttribute("customers", customers);

        return "list-customers";
    }
}
