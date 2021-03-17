package com.example.demo.service.impl;

import com.example.demo.model.Contract;
import com.example.demo.model.Employee;
import com.example.demo.repository.EmployeeRepository;
import com.example.demo.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    @Autowired
    private EmployeeRepository employeeRepository ;



    @Override
    public Page<Employee> findAllInputTex(String keyword, Pageable pageable) {
        return employeeRepository.findAllInputTex(keyword, pageable);
    }

    @Override
    public Page<Employee> findAll(Pageable pageable) {
        return employeeRepository.findAll(pageable);
    }

    @Override
    public Employee findById(int id) {
        return employeeRepository.findById(id).orElse(null);
    }

    @Override
    public void save(Employee employee) {
        employeeRepository.save(employee) ;
    }

    @Override
    public void remove(int id) {
        employeeRepository.deleteById(id);
    }
}
