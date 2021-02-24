package com.example.controller;

import com.example.model.Email;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;

@Controller
public class EmailController {

    @GetMapping("/home")
    public String home(Model model){
        model.addAttribute("email" , new Email());
        List<String> languageList = new ArrayList<>() ;
        languageList.add("English");
        languageList.add("Vietnamese");
        languageList.add("Japanese");
        languageList.add("Chinese");
        model.addAttribute("languageList" , languageList) ;

        List<Integer> sizeList = new ArrayList<>() ;
        sizeList.add(5) ;
        sizeList.add(10) ;
        sizeList.add(15) ;
        sizeList.add(25) ;
        sizeList.add(50) ;
        sizeList.add(100) ;
        model.addAttribute("sizeList" , sizeList);

        return "/home" ;
    }

    @PostMapping("/result")
    public String result(@ModelAttribute Email email , Model model){
        model.addAttribute("language" , email.getLanguage()) ;
        model.addAttribute("pageSize" , email.getPageSize()) ;
        model.addAttribute("spamFilter" , email.isSpamFilter()) ;
        model.addAttribute("signature" , email.getSignature()) ;

        return "/result" ;
    }
}
