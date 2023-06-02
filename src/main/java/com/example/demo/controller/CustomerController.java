package com.example.demo.controller;

import com.example.demo.models.Customer;
import com.example.demo.repositories.CustomerRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class CustomerController {

    CustomerRepository customerRepository; // interface를 사용하기 위한 작업

    // CustomerController Constructor => CustomerRepository 타입
    public CustomerController(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    };
    // Get type => customers
    @GetMapping(value = "/customers")
    public String list(Model model) { // ui에 보낼 model 설정
        List<Customer> customers = (List<Customer>) customerRepository.findAll(); // 강제 형변환List<Customer>
        model.addAttribute("customers", customers); // url => customers
        return "customers/customerList";
    }
}
