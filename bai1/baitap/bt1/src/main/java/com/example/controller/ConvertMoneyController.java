package com.example.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class ConvertMoneyController {
    @GetMapping("/")
    public String convertMoney(){
        return"/convert" ;
    }


}
