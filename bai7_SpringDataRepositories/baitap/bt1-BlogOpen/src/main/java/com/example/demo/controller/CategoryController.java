package com.example.demo.controller;

import com.example.demo.model.Category;
import com.example.demo.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @GetMapping("/categories")
    public ModelAndView listCategory(@PageableDefault (size = 5) Pageable pageable){
        return new ModelAndView("/category/list","categoryList",categoryService.findAll(pageable));
    }

    @GetMapping("/category/create")
    public ModelAndView createForm(){
        return new ModelAndView("/category/create","category", new Category());
    }
    @PostMapping("/category/save")
    public String save(Category category, RedirectAttributes redirect){
        categoryService.save(category);
        redirect.addFlashAttribute("success", "Add new category successfully !!");
        return "redirect:/categories";
    }

    @GetMapping("/category/{id}/edit")
    public ModelAndView edit(@PathVariable int id){
        return new ModelAndView("/category/edit","category", categoryService.findById(id));
    }
    @PostMapping("/category/update")
    public String update(Category category){
        categoryService.save(category);
        return "redirect:/categories";
    }

    @GetMapping("/category/{id}/delete")
    public ModelAndView delete(@PathVariable int id){
        return new ModelAndView("/category/delete","category", categoryService.findById(id));
    }
    @PostMapping("/category/delete")
    public String delete(Category category, RedirectAttributes redirect){
        categoryService.remove(category.getId());
        redirect.addFlashAttribute("success", "Removed blog successfully !!");
        return "redirect:/categories";
    }


}