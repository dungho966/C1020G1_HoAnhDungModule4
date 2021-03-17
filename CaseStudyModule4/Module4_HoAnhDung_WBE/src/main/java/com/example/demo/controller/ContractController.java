package com.example.demo.controller;

import com.example.demo.model.*;
import com.example.demo.service.*;
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
public class ContractController {
    @Autowired
    private EmployeeService employeeService ;
    @Autowired
    private ServiceService serviceService ;
    @Autowired
    private CustomerService customerService ;
    @Autowired
    private ContractService contractService ;

    @Autowired
    private ContractDetailService contractDetailService ;

    @Autowired
    private AttackServiceService attackServiceService ;

    @ModelAttribute("employeeContract")
    public Page<Employee> employees(Pageable pageable){
        return employeeService.findAll(pageable) ;
    }

    @ModelAttribute("serviceContract")
    public Page<Service> services(Pageable pageable){
        return serviceService.findAllService(pageable) ;
    }

    @ModelAttribute("customerContract")
    public Page<Customer> customers(Pageable pageable){
        return customerService.findAllCustomer(pageable) ;
    }

    @ModelAttribute("contractdetailservice")
    public Page<ContractDetail> contractDetails(Pageable pageable){
        return contractDetailService.findAllContractDetail(pageable) ;
    }

    @ModelAttribute("contractdetailservice")
    public Page<AttackService> attackServices(Pageable pageable){
        return attackServiceService.findAllAttackService(pageable) ;
    }

    @GetMapping("/contractlist")
    public ModelAndView list(@PageableDefault(size = 5) Pageable pageable){
        return new ModelAndView("/contract/list" , "contractlist" ,
                contractService.findAllContract(pageable)) ;
    }

    @GetMapping("/contract/create")
    public String Create(Model model){
        model.addAttribute("contract" , new Contract()) ;
        return "contract/create" ;
    }

    @PostMapping("/contract/save")
    public String Save(@Validated BindingResult bindingResult , Contract contract , RedirectAttributes redirect){
        if (bindingResult.hasFieldErrors()) {
            return "/contract/create";
        }
        contractService.save(contract);
        redirect.addFlashAttribute("success" , "add new employee successfully") ;
        return "redirect:/contractlist" ;
    }

    @GetMapping("/contract/{id}/edit")
    public String edit(@PathVariable int id, Model model){
        model.addAttribute("contract", contractService.findById(id));
        return "/contract/edit";
    }
    @PostMapping("/contract/update")
    public String update(Contract contract){
        contractService.save(contract);
        return "redirect:/customerlist";
    }

    @GetMapping("/contract/{id}/delete")
    public String delete(@PathVariable int id, Model model){
        model.addAttribute("contract", contractService.findById(id));
        return "/contract/delete";
    }
    @PostMapping("/contract/delete")
    public String delete(@ModelAttribute Contract contract, RedirectAttributes redirect){
        contractService.remove(contract.getContractId());
        redirect.addFlashAttribute("success", "Removed customer successfully !!");
        return "redirect:/contractlist";
    }


    @GetMapping("/contract/{id}/view")
    public String view(@PathVariable int id, Model model){
        model.addAttribute("contract", contractService.findById(id));
        return "/contract/view";
    }

    @GetMapping("/contract/search")
    public String index(Model model, @PageableDefault (size = 5) Pageable pageable, @RequestParam("keyword") Optional<String> keyword){
        Page<Contract> contracts;
        if (keyword.isPresent()){
            contracts = contractService.findAllInputTex(keyword.get() ,pageable) ;
        } else {
            contracts = contractService.findAllContract(pageable) ;
        }
        model.addAttribute("customerlist", contracts);
        return "/contract/list";
    }
}
