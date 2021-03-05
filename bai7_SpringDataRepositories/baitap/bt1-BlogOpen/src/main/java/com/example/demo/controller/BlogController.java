package com.example.demo.controller;

import com.example.demo.model.Blog;
import com.example.demo.model.Category;
import com.example.demo.service.BlogService;
import com.example.demo.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Optional;

@Controller
public class BlogController {

    @Autowired
    private BlogService blogService;

    @Autowired
    private CategoryService categoryService;

    @ModelAttribute("categories")
    public Iterable<Category> categories(){
        return categoryService.findAll();
    }

    @GetMapping("/")
    public String index(Model model, @PageableDefault (size = 5,sort = "dateUpdate") Pageable pageable, @RequestParam("s")Optional<String> s){
        Page<Blog> blogList;
        if (s.isPresent()){
            blogList = blogService.findAllByName(s.get(), pageable);
        } else {
            blogList = blogService.findAllBlog(pageable);
        }
        model.addAttribute("blogList", blogList);
        return "/blog/list";
    }

    @GetMapping("/blog/create")
    public String create(Model model){

        model.addAttribute("blog", new Blog());
        return "/blog/create";
    }
    @PostMapping("/blog/save")
    public String save(Blog blog, RedirectAttributes redirect){
        DateFormat df = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        Date today = Calendar.getInstance().getTime();
        String date = df.format(today);
        blog.setDateUpdate(date);
        blogService.save(blog);
        redirect.addFlashAttribute("success","Add new blog successfully !!");
        return "redirect:/";
    }

    @GetMapping("/blog/{id}/edit")
    public String edit(@PathVariable int id, Model model){
        model.addAttribute("blog", blogService.findById(id));
        return "/blog/edit";
    }
    @PostMapping("/blog/update")
    public String update(Blog blog){
        blogService.save(blog);
        return "redirect:/";
    }

    @GetMapping("/blog/{id}/delete")
    public String delete(@PathVariable int id, Model model){
        model.addAttribute("blog", blogService.findById(id));
        return "/blog/delete";
    }
    @PostMapping("/blog/delete")
    public String delete(Blog blog, RedirectAttributes redirect){
        blogService.remove(blog.getId());
        redirect.addFlashAttribute("success", "Removed blog successfully !!");
        return "redirect:/";
    }

    @GetMapping("/blog/{id}/view")
    public String view(@PathVariable int id, Model model){
        model.addAttribute("blog", blogService.findById(id));
        return "/blog/view";
    }

}