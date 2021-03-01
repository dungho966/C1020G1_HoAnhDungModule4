package com.example.controller;

import com.example.entity.Product;
import com.example.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class ProductController {
    @Autowired
    private ProductService productService;

    @GetMapping("/")
    public String goHome(
            Model model) {
        model.addAttribute( "products", productService.showAllProduct() );
        return "/home";
    }

    @GetMapping("/product/create")
    public String create(Model model) {
        model.addAttribute( "product", new Product() );
        return "/create";
    }

    @GetMapping("/product/edit/{id}")
    public String edit(@PathVariable Integer id, Model model) {
        model.addAttribute( "product", productService.findProductById( id ) );
        return "/edit";
    }

    @GetMapping("/product/view/{id}")
    public String view(@PathVariable Integer id, Model model) {
        model.addAttribute( "product", productService.findProductById( id ) );
        return "/view";
    }

    @GetMapping("/product/delete/{id}")
    public String delete(@PathVariable Integer id) {
        productService.deleteProduct( id );
        return "redirect:/";
    }

    @PostMapping("/product/save")
    public String save(@ModelAttribute Product product, @RequestParam String action) {
        productService.saveProduct( action, product );
        return "redirect:/";
    }
}