package com.example.demo.controller;

import com.example.demo.model.Blog;
import com.example.demo.model.Category;
import com.example.demo.service.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class BlogRestController {
    @Autowired
    private BlogService blogService ;

    @RequestMapping(value = "/blog" , method = RequestMethod.GET)
    public ResponseEntity<List<Blog>> listAllCategory() {
        List<Blog> blogs = (List<Blog>) blogService.findAll();
        if (blogs.isEmpty()){
            return new ResponseEntity<List<Blog>>(blogs , HttpStatus.NO_CONTENT) ;
        }
        return new ResponseEntity<List<Blog>>(blogs , HttpStatus.OK) ;
    }

    @RequestMapping(value = "/blog/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Blog> getCustomer(@PathVariable("id") int id) {
        System.out.println("Fetching Customer with id " + id);
        Blog blog = blogService.findById(id);
        if (blog == null) {
            System.out.println("Blog with id " + id + " not found");
            return new ResponseEntity<Blog>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<Blog>(blog, HttpStatus.OK);
    }
}
