package com.example.demo.controller;

import com.example.demo.model.Contract;
import com.example.demo.model.Customer;
import com.example.demo.model.CustomerType;
import com.example.demo.model.Employee;
import com.example.demo.service.ContractService;
import com.example.demo.service.CustomerService;
import com.example.demo.service.CustomerTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.Optional;

@Controller
public class CustomerController {
    @Autowired
    private CustomerService customerService ;

    @Autowired
    private CustomerTypeService customerTypeService ;

    @Autowired
    private ContractService contractService ;

    @ModelAttribute("customertype")
    public Page<CustomerType> customerTypes(Pageable pageable){
        return customerTypeService.findAllCustomerType(pageable);
    }

    @ModelAttribute("contract")
    public Page<Contract> contracts(Pageable pageable){
        return contractService.findAllContract(pageable);
    }

    @GetMapping("/customerlist")
    public ModelAndView list(@PageableDefault(size = 5) Pageable pageable){
        return new ModelAndView("/customer/list" , "customerlist" ,
                customerService.findAllCustomer(pageable)) ;
    }

    @GetMapping("/customer/create")
    public String Create(Model model){
        model.addAttribute("customer" , new Customer()) ;
        return "customer/create" ;
    }

    @PostMapping("/customer/save")
    public String Save(@Validated BindingResult bindingResult ,Customer customer , RedirectAttributes redirect){
        if (bindingResult.hasFieldErrors()) {
            return "/customer/create";
        }
        customerService.save(customer);
        redirect.addFlashAttribute("success" , "add new employee successfully") ;
        return "redirect:/customerlist" ;
    }

    @GetMapping("/customer/{id}/edit")
    public String edit(@PathVariable int id, Model model){
        model.addAttribute("customer", customerService.findById(id));
        return "/customer/edit";
    }
    @PostMapping("/customer/update")
    public String update(Customer customer){
        customerService.save(customer);
        return "redirect:/customerlist";
    }

    @GetMapping("/customer/{id}/delete")
    public String delete(@PathVariable int id, Model model){
        model.addAttribute("customer", customerService.findById(id));
        return "/customer/delete";
    }
    @PostMapping("/customer/delete")
    public String delete(@ModelAttribute Customer customer, RedirectAttributes redirect){
        customerService.remove(customer.getCustomerId());
        redirect.addFlashAttribute("success", "Removed customer successfully !!");
        return "redirect:/customerlist";
    }


    @GetMapping("/customer/{id}/view")
    public String view(@PathVariable int id, Model model){
        model.addAttribute("customer", customerService.findById(id));
        return "/customer/view";
    }

    @GetMapping("/customer/search")
    public String index(Model model, @PageableDefault (size = 5) Pageable pageable, @RequestParam("keyword") Optional<String> keyword){
        Page<Customer> customers;
        if (keyword.isPresent()){
            customers = customerService.findAllInputTex(keyword.get() ,pageable) ;
        } else {
            customers = customerService.findAllCustomer(pageable) ;
        }
        model.addAttribute("customerlist", customers);
        return "/customer/list";
    }


}
