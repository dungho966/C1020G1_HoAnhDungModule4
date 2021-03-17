package com.example.demo.service;

import com.example.demo.model.Contract;
import com.example.demo.model.Employee;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface EmployeeService {
    Page<Employee> findAllInputTex(String keyword, Pageable pageable);
    Page<Employee> findAll(Pageable pageable);
    Employee findById(int id);
    void save(Employee employee);
    void remove(int id);
}
