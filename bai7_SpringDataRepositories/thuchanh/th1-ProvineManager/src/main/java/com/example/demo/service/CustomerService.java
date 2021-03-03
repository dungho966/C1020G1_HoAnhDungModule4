package com.example.demo.service;


import com.example.demo.model.Customer;
import org.springframework.stereotype.Service;

import java.util.List;



public interface CustomerService {
    Iterable<Customer> findAll();

    Customer findById(Integer id);

    void save(Customer customer);

    void remove(Integer id);

}
