package com.udemy.spring.controller;

import com.udemy.spring.model.Customer;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@Controller
@RequestMapping("/customer")
public class CustomerController {

    @RequestMapping("/showCustomerForm")
    public String showCustomerForm(Model model) {
        model.addAttribute("customer", new Customer());
        return "customer-form";
    }

    @RequestMapping("/processCustomerForm")
    public String processCustomerForm(@Valid @ModelAttribute("customer") Customer customer, BindingResult result) {
        if(!result.hasErrors()) {
            return "customer-confirmation";
        } else {
            return "customer-form";
        }
    }
}
