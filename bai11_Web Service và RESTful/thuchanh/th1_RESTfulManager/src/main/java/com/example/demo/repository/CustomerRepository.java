package com.example.demo.repository;

import com.example.demo.model.Customer;


import java.util.List;

public interface CustomerRepository {
    List<Customer> findAll();

    Customer findById(Long id);

    void save(Customer customer);

    void remove(Long id);
}
