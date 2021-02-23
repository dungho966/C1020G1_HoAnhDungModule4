package com.example.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class CalculationController {

    @GetMapping("/home")
    public String home(){
        return "/home" ;
    }

    @GetMapping("/result")
    public String result(@RequestParam String cal ,@RequestParam int number1 , @RequestParam int number2  , Model model){
        int res = 0 ;
        String message = null;
        switch (cal){
            case "+":
                res = number1 + number2 ;
                break;
            case "-":
                res = number1 - number2 ;
                break;
            case "*":
                res = number1 * number2 ;
                break;
            case "/":
                if (number2 == 0){
                    message = "Can't not division by zero";
                }else {
                    res = number1 / number2;
                }
                break;
        }
        if (message == null) {
        model.addAttribute("res" , res ) ;
        } else {
            model.addAttribute("res" , message) ;
        }
        return "/home" ;
    }
}
