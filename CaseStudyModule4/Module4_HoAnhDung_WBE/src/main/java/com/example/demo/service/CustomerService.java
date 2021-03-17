package com.example.demo.service;

import com.example.demo.model.Customer;
import com.example.demo.model.Position;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface CustomerService {
    Page<Customer> findAllCustomer(Pageable pageable);
    Customer findById(int id);
    void save(Customer customer);
    void remove(int id);
}
