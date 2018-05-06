package com.udemy.spring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
public class HelloWorldController {

    @RequestMapping("/showForm")
    public String showForm() {
        return "hello-world-form";
    }

    @RequestMapping("/processForm")
    public String processForm() {
        return "hello-world";
    }

    @RequestMapping("processFormVersionTwo")
    public String letsShout(HttpServletRequest request, Model model) {

        model.addAttribute("message", "Yo! " + request.getParameter("studentName").toUpperCase());

        return "hello-world";
    }
}
