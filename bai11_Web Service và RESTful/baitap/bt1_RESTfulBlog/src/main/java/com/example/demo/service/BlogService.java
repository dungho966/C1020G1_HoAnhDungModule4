package com.example.demo.service;

import com.example.demo.model.Blog;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;


public interface BlogService {
        Page<Blog> findAllByName (String name, Pageable pageable);
        Page<Blog> findAllBlog(Pageable pageable);
        Blog findById(int id);
        void save(Blog blog);
        void remove(int id);
//        Page<Blog> findBlogByOrderByDateUpdateDesc(Pageable pageable);
}