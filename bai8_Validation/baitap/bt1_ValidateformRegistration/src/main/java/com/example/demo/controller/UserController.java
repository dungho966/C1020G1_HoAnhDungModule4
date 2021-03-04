package com.example.demo.controller;


import com.example.demo.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;

@Controller
public class UserController {
    @GetMapping("/")
    public String home(Model model){
        model.addAttribute("user",new User());
        return "home" ;
    }

    @PostMapping("/")
    public String result(@Valid @ModelAttribute("user") User user, BindingResult bindingResult, Model model){
        new User().validate(user , bindingResult);
        if (bindingResult.hasFieldErrors()){
            return "home" ;
        }
        else {
            model.addAttribute("user" , user);
            return "result" ;
        }
    }
}
