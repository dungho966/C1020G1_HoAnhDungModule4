package com.example.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.sql.Array;
import java.util.Arrays;

@Controller
public class SandwichController {

    @GetMapping("/home")
    public String home(){
        return "/home" ;
    }

    @GetMapping("/result")
    public String result(@RequestParam String [] condiment , Model model){
        model.addAttribute("condiment" , Arrays.toString(condiment)) ;
        return "/result" ;
    }

}
