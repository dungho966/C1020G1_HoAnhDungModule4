package com.example.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ConvertController {
    @GetMapping("/home")
    public String change(){
        return "home";
    }
    @GetMapping("/result")
    public String result(@RequestParam int usd , Model model ){
        double vnd = usd * 22000 ;
        model.addAttribute("usd" , usd) ;
        model.addAttribute("vnd" , vnd) ;
        return "result" ;

    }

}
