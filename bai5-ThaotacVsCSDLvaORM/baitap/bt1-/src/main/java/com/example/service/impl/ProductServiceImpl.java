package com.example.service.impl;

import com.example.entity.Product;
import com.example.repository.ProductRepository;
import com.example.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    ProductRepository productRepository;

    @Override
    public List<Product> showAllProduct() {
        return productRepository.showAllProduct();
    }

    @Override
    public void deleteProduct(Integer id) {
        productRepository.deleteProduct( id );
    }

    @Override
    public Product findProductById(Integer id) {
        return productRepository.findProductById( id );
    }

    @Override
    public void saveProduct(String action, Product product) {
        productRepository.saveProduct( action, product );
    }
}