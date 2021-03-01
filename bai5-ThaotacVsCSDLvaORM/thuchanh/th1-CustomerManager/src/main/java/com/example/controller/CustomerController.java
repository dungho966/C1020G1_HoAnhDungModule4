package com.example.controller;


import com.example.entity.Customer;
import com.example.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class CustomerController {
    @Autowired
    private CustomerService customerService;
    @GetMapping("/")
    public String goHome(Model model){
        model.addAttribute( "customers",customerService.showAllCustomer() );
        return "/view";
    }
    @GetMapping("/customer/create")
    public String create(Model model){
        model.addAttribute( "customer", new Customer() );
        return "/create";
    }

    @GetMapping("/customer/edit/{id}")
    public String update(@PathVariable Integer id, Model model){
        model.addAttribute( "customer", customerService.findCustomerById( id ) );
        return "/edit";
    }

    @GetMapping("/customer/delete/{id}")
    public String remove(@PathVariable Integer id){
        customerService.deleteCustomer( id );
        return "redirect:/";
    }

    @PostMapping("/customer/save")
    public String save(@ModelAttribute Customer customer, @RequestParam String action , Model model){
        switch (action){
            case "create":
                customerService.createCustomer( customer );
                break;
            case "edit":
                customerService.editCustomer( customer );
                break;
            default:
        }
        return "redirect:/";
    }
}