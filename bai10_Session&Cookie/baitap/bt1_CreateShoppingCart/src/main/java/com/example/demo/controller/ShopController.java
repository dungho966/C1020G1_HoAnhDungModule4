package com.example.demo.controller;

import com.example.demo.model.Product;
import com.example.demo.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


import java.util.HashMap;
import java.util.Map;



@Controller
@SessionAttributes("cart")
class ShopController {

    @Autowired
    ProductService productService;

    @GetMapping({"","/product"})
    public String productList(Model model){
        model.addAttribute("products",productService.findAll());
        return "home";
    }



    @GetMapping("/product/{id}/add")
    public String addProduct(@ModelAttribute("cart") Map<Product,Integer> cart,Model model,@PathVariable Integer id){
        Product product = productService.findById(id);
        if(cart.get(product) == null){
            cart.put(product,1);
        }else {
            cart.replace(product,cart.get(product),cart.get(product)+1);
        }
        return "redirect:/";
    }

    @GetMapping("product/cart/{id}/delete")
    public String deleteProduct(@PathVariable Integer id,@ModelAttribute("cart") Map<Product,Integer> cart,Model model){
        cart.remove(productService.findById(id));
        model.addAttribute("cart",cart);
        return "redirect:/";
    }

    @GetMapping("/product/cart/delete")
    public String deleteAll(@ModelAttribute("cart") Map<Product,Integer> cart){
        cart.clear();
        return "redirect:/";
    }
    @GetMapping("/buyFlower")
    public String buyProduct(@ModelAttribute("cart") Map<Product,Integer> cart,Model model){
        model.addAttribute("cart",cart);
        return "buyflower";
    }

    @GetMapping("/product/cart/{id}/quantity")
    public String editQuantityProductForm( @PathVariable Integer id, Model model ){
        Product product = productService.findById(id);
        model.addAttribute("product",product);
        return "quantity";
    }

    @PostMapping("/quantity")
    public String editQuantityProduct(@ModelAttribute("cart") Map<Product,Integer> cart,  Product product,
                                      @RequestParam Integer quantity ){
        cart.replace(product,cart.get(product),quantity);
        if(quantity < 0){
            return "error";
        }
        return "redirect:/";

    }
    @ModelAttribute("cart")
    public Map<Product,Integer> cart(){
        return new HashMap<>();
    }

}
