package com.example.customer.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.customer.business.domain.Customer;
import com.example.customer.business.service.CustomerService;

@Controller
public class CustomerListController {

    @Autowired
    private CustomerService customerService;

    @GetMapping(value = "/")
    public String home() {
        return "forward:/customer";
    }
    
    // TODO 演習8 不足しているアノテーションを記述しなさい
    public String showAllCustomers(Model model) {
        List<Customer> customers = customerService.findAll();
     // TODO 演習8 モデルにCustomersを設定して、リターンを修正しなさい
        return null;
    }
}
