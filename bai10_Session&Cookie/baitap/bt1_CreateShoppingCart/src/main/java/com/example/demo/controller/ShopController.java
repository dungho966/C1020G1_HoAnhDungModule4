package com.example.demo.controller;

import com.example.demo.model.Product;
import com.example.demo.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;


@Controller
@SessionAttributes(value = "productCast")
public class ShopController {

    @Autowired
    private ProductService productService;


    @GetMapping("/")
    public String home() {
        return "home";
    }

    @GetMapping("/sp1")
    public String sp1(Model model){
        model.addAttribute("productAdd" , new Product()) ;
        return "/detail/detail1" ;
    }
    @GetMapping("/sp2")
    public String sp2(){
        return "/detail/detail2" ;
    }
    @GetMapping("/sp3")
    public String sp3(){
        return "/detail/detail3" ;
    }
    @GetMapping("/sp4")
    public String sp4(){
        return "/detail/detail4" ;
    }


    @PostMapping("/save")
    public String save(Product product, RedirectAttributes redirectAttributes) {
        productService.save(product);
        redirectAttributes.addFlashAttribute("message", "Create Successfully");
        return "redirect:/";
    }

}
