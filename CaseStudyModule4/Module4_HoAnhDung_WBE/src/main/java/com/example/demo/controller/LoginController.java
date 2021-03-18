package com.example.demo.controller;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginController {

    @GetMapping("/login")
    public String login(){
        return "login/login" ;
    }

    public static void main(String[] args) {
        System.out.println(new BCryptPasswordEncoder().encode("456"));
    }


}
