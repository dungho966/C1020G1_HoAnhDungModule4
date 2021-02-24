package com.example.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Arrays;

@Controller
public class HomeController {

    @GetMapping("/home")
    public String Home(){
        return "/home" ;
    }

    @GetMapping("/result")
    public String Result(@RequestParam String language ,@RequestParam String maximum ,@RequestParam(required = false) Boolean yesno,
                         @RequestParam String signature , Model model){
        model.addAttribute("language" , language) ;
        model.addAttribute("maximum" , maximum) ;
        model.addAttribute("yesno" , yesno) ;
        model.addAttribute("signature" , signature) ;
        return "/result" ;


    }



}
