package com.example.service;

import com.example.entity.Product;

import java.util.List;

public interface ProductService {
    List<Product> showAllProduct();

    void deleteProduct(Integer id);

    Product findProductById(Integer id);

    void saveProduct(String action, Product product);
}