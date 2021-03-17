package com.example.demo.service;

import com.example.demo.model.Customer;
import com.example.demo.model.CustomerType;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface CustomerTypeService {
    Page<CustomerType> findAllCustomerType(Pageable pageable);
    CustomerType findById(int id);
    void save(CustomerType customerType);
    void remove(int id);
}
