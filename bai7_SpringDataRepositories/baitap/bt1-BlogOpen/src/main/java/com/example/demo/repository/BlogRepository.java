package com.example.demo.repository;

import com.example.demo.model.Blog;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BlogRepository extends PagingAndSortingRepository<Blog, Integer> {
    Page<Blog> findAllByName (String name, Pageable pageable);
//    Page<Blog> findBlogByOrderByDateUpdateDesc(Pageable pageable);
}