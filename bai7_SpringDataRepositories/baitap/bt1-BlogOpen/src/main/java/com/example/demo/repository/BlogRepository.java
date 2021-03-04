package com.example.demo.repository;


import com.example.demo.model.Blog;
import com.example.demo.model.Category;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BlogRepository extends PagingAndSortingRepository<Blog,Integer> {
    Page<Blog> findByOrderByDateUpdateDesc(Pageable pageable);
    Iterable<Blog> findAllByCategory(Category category);
    Page<Blog> findByName(String name, Pageable pageable);
}
