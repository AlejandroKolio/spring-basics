package com.udemy.spring.controller;

import com.udemy.spring.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/user")
public class UserController {

    @RequestMapping("/showForm")
    public String showUserForm(Model model) {
        model.addAttribute("user", new User());
        return "user-form";
    }

    @RequestMapping("/processForm")
    public String processUserForm(@ModelAttribute("user") User user) {
        System.out.println("First Name: \t" + user.getFirstName());
        System.out.println("Last Name:  \t" + user.getLastName());
        return "user-confirmation";
    }
}
