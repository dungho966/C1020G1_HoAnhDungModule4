package com.example.demo.service;

import com.example.demo.model.Employee;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface EmployeeService {
    Page<Employee> findAllByEmployeeName (String name, Pageable pageable);
    Page<Employee> findAllEmployee(Pageable pageable);
    Employee findById(int id);
    void save(Employee employee);
    void remove(int id);
}