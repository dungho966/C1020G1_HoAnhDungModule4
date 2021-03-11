package com.example.demo.service;

import com.example.demo.model.Cart;
import com.example.demo.model.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Map;

public interface ProductService {
    Page<Product> findAll(Pageable pageable);

    Product findById(int id);

    void addToCart(Map<Product, Cart> carts, int id);

    double getTotal(Map<Product, Cart> carts);

    void delete(Map<Product, Cart> carts, int id);

    void update(Map<Product, Cart> carts, int id, int quantity);

}
