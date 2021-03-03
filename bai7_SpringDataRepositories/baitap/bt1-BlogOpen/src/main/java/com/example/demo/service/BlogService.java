package com.example.demo.service;

import com.example.demo.model.Blog;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface BlogService {
        Page<Blog> findAll(Pageable pageable);

        Blog findById(Integer id);

        void save(Blog blog);

        void remove(Integer id);

        Page<Blog> findAllByTitleContaining(String tittle, Pageable pageable);
}
