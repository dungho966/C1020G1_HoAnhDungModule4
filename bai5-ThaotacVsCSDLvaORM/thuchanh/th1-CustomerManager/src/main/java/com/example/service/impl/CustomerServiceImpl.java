package com.example.service.impl;

import com.example.entity.Customer;
import com.example.repository.CustomerRepository;
import com.example.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CustomerServiceImpl implements CustomerService {
    @Autowired
    private CustomerRepository customerRepository;
    @Override
    public List<Customer> showAllCustomer() {
        return customerRepository.showAllCustomer();
    }

    @Override
    public void deleteCustomer(Integer id) {
        customerRepository.deleteCustomer( id );
    }

    @Override
    public void editCustomer(Customer customer) {
        customerRepository.editCustomer( customer );
    }

    @Override
    public void createCustomer(Customer customer) {
        customerRepository.createCustomer(customer);
    }

    @Override
    public Customer findCustomerById( Integer id) {
        return customerRepository.findCustomerById(id);
    }
}