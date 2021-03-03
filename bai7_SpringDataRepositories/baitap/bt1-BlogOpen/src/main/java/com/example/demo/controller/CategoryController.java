package com.example.demo.controller;

import com.example.demo.model.Blog;
import com.example.demo.model.Category;
import com.example.demo.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class CategoryController {
    @Autowired
    private CategoryService categoryService ;

    @GetMapping("/create-category")
    public ModelAndView home(){
        ModelAndView modelAndView = new ModelAndView("/category/create") ;
        modelAndView.addObject("category" , new Category()) ;
        return modelAndView ;
    }

    @PostMapping("/create-category")
    public ModelAndView save(@ModelAttribute("category") Category category){
        categoryService.save(category);
        ModelAndView modelAndView = new ModelAndView("/category/create") ;
        modelAndView.addObject("category" , new Category());
        modelAndView.addObject("message" , "New category created successfully") ;
        return modelAndView;
    }

    @GetMapping("/list-category")
    public ModelAndView listCategory(Pageable pageable){
        Page<Category> categories = categoryService.findAll(pageable) ;
        ModelAndView modelAndView = new ModelAndView("/category/list") ;
        modelAndView.addObject("categories" , categories) ;
        return modelAndView ;
    }

    @GetMapping("/edit-category/{id}")
    public ModelAndView showEditForm(@PathVariable Integer id){
        Category category = categoryService.findById(id);
        if(category != null) {
            ModelAndView modelAndView = new ModelAndView("/category/edit");
            modelAndView.addObject("category", category);
            return modelAndView;

        }else {
            ModelAndView modelAndView = new ModelAndView("/error.404");
            return modelAndView;
        }
    }

    @PostMapping("/edit-category")
    public ModelAndView updateCustomer(@ModelAttribute("category") Category category){
        categoryService.save(category);
        ModelAndView modelAndView = new ModelAndView("/category/edit");
        modelAndView.addObject("category", category);
        modelAndView.addObject("message", "Category updated successfully");
        return modelAndView;
    }

    @GetMapping("/delete-category/{id}")
    public ModelAndView showDeleteForm(@PathVariable Integer id){
        Category category = categoryService.findById(id);
        if(category != null) {
            ModelAndView modelAndView = new ModelAndView("/category/delete");
            modelAndView.addObject("category", category);
            return modelAndView;

        }else {
            ModelAndView modelAndView = new ModelAndView("/error.404");
            return modelAndView;
        }
    }

    @PostMapping("/delete-category")
    public String deleteCustomer(@ModelAttribute("category") Category category){
        categoryService.remove(category.getId());
        return "redirect:list-category";
    }



}
