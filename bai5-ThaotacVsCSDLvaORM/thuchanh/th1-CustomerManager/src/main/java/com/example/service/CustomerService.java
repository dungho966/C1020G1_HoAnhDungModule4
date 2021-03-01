package com.example.service;

import com.example.entity.Customer;

import java.util.List;

public interface CustomerService {
    List<Customer> showAllCustomer();
    void deleteCustomer(Integer id);
    void editCustomer(Customer customer);
    void createCustomer(Customer customer);
    Customer findCustomerById(Integer id);
}