package com.example.demo.controller;

import com.example.demo.model.Credential;
import com.example.demo.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;



@Controller
@SessionAttributes("user")
public class LoginController {
    @GetMapping("/login")
    public String login(@ModelAttribute("credential") Credential credential) {
        return "login";
    }

    @PostMapping("/login")
    public String dashboard(@ModelAttribute("credential") Credential credential, Model model) {
        User user = new User();
        user.setUserName(credential.getUsername());
        model.addAttribute("user", user);
        return "redirect:dashboard";
    }

}
