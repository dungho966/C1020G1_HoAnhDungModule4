package com.example.demo.controller;

import com.example.demo.model.*;
import com.example.demo.service.DivisionService;
import com.example.demo.service.EducationDegreeService;
import com.example.demo.service.EmployeeService;
import com.example.demo.service.PositionService;
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
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService ;

    @Autowired
    private PositionService positionService ;

    @Autowired
    private DivisionService divisionService ;

    @Autowired
    private EducationDegreeService educationDegreeService ;

    @ModelAttribute("educationdegree")
    public Iterable<EducationDegree> educationDegrees(){
        return educationDegreeService.findAll();
    }

    @ModelAttribute("division")
    public Iterable<Division> divisions(){
        return divisionService.findAllDivision();
    }

    @ModelAttribute("position")
    public Page<Position> positions( Pageable pageable){
        return positionService.findAllPosition(pageable) ;
    }

    @GetMapping("/employeelist")
    public ModelAndView list(@PageableDefault(size = 5) Pageable pageable){
        return new ModelAndView("/employee/list" , "employeelist" ,
                employeeService.findAll(pageable)) ;
    }


    @GetMapping("/employee/create")
    public String Create(Model model){
        model.addAttribute("employee" , new Employee()) ;
        return "employee/create" ;
    }

    @PostMapping("/employee/save")
    public String Save(@Validated BindingResult bindingResult ,Employee employee , RedirectAttributes redirect){
        if (bindingResult.hasFieldErrors()) {
            return "/employee/create";
        }
        employeeService.save(employee);
        redirect.addFlashAttribute("success" , "add new employee successfully") ;
        return "redirect:/employeelist" ;
    }

    @GetMapping("/employee/{id}/edit")
    public String edit(@PathVariable int id, Model model){
        model.addAttribute("employee", employeeService.findById(id));
        return "/employee/edit";
    }
    @PostMapping("/employee/update")
    public String update(Employee employee){
        employeeService.save(employee);
        return "redirect:/employeelist";
    }

    @GetMapping("/employee/{id}/delete")
    public String delete(@PathVariable int id, Model model){
        model.addAttribute("employee", employeeService.findById(id));
        return "/employee/delete";
    }
    @PostMapping("/employee/delete")
    public String delete(@ModelAttribute Employee employee, RedirectAttributes redirect){
        employeeService.remove(employee.getEmployeeId());
        redirect.addFlashAttribute("success", "Removed blog successfully !!");
        return "redirect:/employeelist";
    }


    @GetMapping("/employee/{id}/view")
    public String view(@PathVariable int id, Model model){
        model.addAttribute("employee", employeeService.findById(id));
        return "/employee/view";
    }

    @GetMapping("/employee/search")
    public String index(Model model, @PageableDefault (size = 5) Pageable pageable, @RequestParam("keyword") Optional<String> keyword){
        Page<Employee> employees;
        if (keyword.isPresent()){
            employees = employeeService.findAllInputTex(keyword.get() ,pageable) ;
        } else {
            employees = employeeService.findAll(pageable) ;
        }
        model.addAttribute("customerlist", employees);
        return "/customer/list";
    }




}
