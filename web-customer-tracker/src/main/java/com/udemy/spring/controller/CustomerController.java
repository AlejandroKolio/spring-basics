package com.udemy.spring.controller;

import com.udemy.spring.entity.Customer;
import com.udemy.spring.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author alexander.shakhov on 17.05.2018 14:10
 */
@Controller
@RequestMapping("/customer")
public class CustomerController {

    // Need to inject customer dao
    @Autowired
    private CustomerService customerService;

    @GetMapping(value = "/list")
    public String listCustomers(Model model) {
        // 1. Get customers from CustomerService -> which call CustomerDAO and return list.
        List<Customer> customers = customerService.getCustomers();

        // 2. Add customers to the model and forward it to jsp page.
        model.addAttribute("customers", customers);

        return "list-customers";
    }

    @GetMapping("/showFormForAdd")
    public String addCustomer(Model model) {
        Customer customer = new Customer();

        model.addAttribute("customer", customer);

        return "customer-form";
    }

    @PostMapping("/saveCustomer")
    public String saveCustomer(@ModelAttribute("customer") Customer customer) {
        customerService.saveCustomer(customer);
        return "redirect:/customer/list";
    }

    @GetMapping("/showFormForUpdate")
    public String showFormForUpdate(@RequestParam("customerId") Integer id, Model model) {
        Customer customer = customerService.getCustomer(id);

        model.addAttribute("customer", customer);

        return "customer-form";
    }

    @GetMapping("/delete")
    public String delete(@RequestParam("customerId") Integer id) {
        customerService.deleteCustomer(id);
        return "redirect:/customer/list";
    }

    @PostMapping("/search")
    public String searchCustomers(@RequestParam("searchName") String searchName, Model model) {

        // 1. search customers from the service
        List<Customer> theCustomers = customerService.searchCustomers(searchName);

        // 2. add the customers to the model
        model.addAttribute("customers", theCustomers);

        return "list-customers";
    }
}
