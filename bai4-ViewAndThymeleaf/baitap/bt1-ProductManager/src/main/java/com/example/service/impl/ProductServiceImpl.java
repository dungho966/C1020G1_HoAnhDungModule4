package com.example.service.impl;

import com.example.model.Product;
import com.example.service.ProductService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ProductServiceImpl implements ProductService {

    private static Map<Integer , Product> productList ;

    static {
        productList = new HashMap<>();
        productList.put(1 , new Product(1 , "ip6" , 100 , "apple"));
        productList.put(2 , new Product(2 , "ip7" , 200 , "apple"));
        productList.put(3 , new Product(3 , "ip8" , 300 , "apple"));
        productList.put(4 , new Product(4 , "ip9" , 400 , "apple"));
        productList.put(5 , new Product(5 , "ip10" , 500 , "apple"));
        productList.put(6 , new Product(6 , "ip11" , 600 , "apple"));
    }
    @Override
    public List<Product> findAll() {
        return new ArrayList<Product>(productList.values());
    }

    @Override
    public void save(Product product) {
        productList.put(product.getId() , product) ;
    }

    @Override
    public Product findById(int id) {
        return productList.get(id);
    }

    @Override
    public void update(int id, Product product) {
        productList.put(id , product) ;
    }

    @Override
    public void remove(int id) {
        productList.remove(id) ;
    }
}
