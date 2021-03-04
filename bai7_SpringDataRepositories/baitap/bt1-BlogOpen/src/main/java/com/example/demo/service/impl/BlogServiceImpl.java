package com.example.demo.service.impl;

import com.example.demo.model.Blog;
import com.example.demo.model.Category;
import com.example.demo.repository.BlogRepository;
import com.example.demo.service.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class BlogServiceImpl implements BlogService {
    @Autowired
    BlogRepository blogRepository;

    @Override
    public Page<Blog> findAll(Pageable pageable) {
        return blogRepository.findByOrderByDateUpdateDesc(pageable);
    }

    @Override
    public Blog findById(Integer id) {
        return blogRepository.findById(id).orElse(null);
    }

    @Override
    public void save(Blog Blog) {
        blogRepository.save(Blog);
    }

    @Override
    public void delete(Integer id) {
        blogRepository.deleteById(id);
    }

    @Override
    public Iterable<Blog> findAllByCategory(Category category) {
        return blogRepository.findAllByCategory(category);
    }

    @Override
    public Page<Blog> findByName(String name, Pageable pageable) {
        return blogRepository.findByName(name, pageable);
    }
}