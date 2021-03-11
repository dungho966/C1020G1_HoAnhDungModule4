package com.example.demo.controller;

import com.example.demo.model.Blog;
import com.example.demo.service.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
@CrossOrigin
public class BlogRestController {
    @Autowired
    private BlogService blogService ;

    @GetMapping("/blog-list")
    public ResponseEntity<Page<Blog>> index(@PageableDefault(size = 5) Pageable pageable){
        Page<Blog> blogList = blogService.findAllBlog(pageable) ;
        if (blogList.isEmpty()){
           return new ResponseEntity<>(blogList, HttpStatus.NO_CONTENT) ;
        }
        return new ResponseEntity<>(blogList , HttpStatus.OK) ;
    }

    @GetMapping("/search")
    public ResponseEntity<Page<Blog>> search(@PageableDefault(size = 5) Pageable pageable , @RequestParam  String s){
        Page<Blog> blogs = blogService.findAllByName(s , pageable) ;
        return new ResponseEntity<>(blogs , HttpStatus.OK) ;
    }



}
