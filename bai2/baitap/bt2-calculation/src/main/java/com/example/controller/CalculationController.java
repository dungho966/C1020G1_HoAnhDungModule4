package com.example.controller;

import com.example.service.CalculatorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class CalculationController {
    @Autowired
    private CalculatorService calculatorService ;

    @GetMapping("/home")
    public String home(){
        return "/home" ;
    }

    @GetMapping("/result")
    public String result(@RequestParam String cal ,@RequestParam int number1 , @RequestParam int number2  , Model model){

        model.addAttribute("res" , calculatorService.operator(number1 , number2 , cal)) ;
        return "/home" ;
    }
}
