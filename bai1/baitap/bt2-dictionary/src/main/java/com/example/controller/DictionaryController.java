package com.example.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.HashMap;
import java.util.Map;

@Controller
public class DictionaryController {
    @GetMapping("/home")
    public String home() {
        return "/home" ;
    }
    @GetMapping("/result")
    public String result(@RequestParam String english , Model model) {
        Map<String , String> dic =new HashMap<>();
        dic.put("Hello" , "Xin Chào");
        dic.put("How" , "Thế Nào");
        dic.put("What" , "Cái Gì");
        dic.put("Computer" , "Máy Tính");
        String result = null ;

        if (dic.get(english) == null){
            result = "not found" ;
        } else {
            result = dic.get(english) ;
        }

        model.addAttribute("result" , result) ;


        return "/result" ;

    }
}
