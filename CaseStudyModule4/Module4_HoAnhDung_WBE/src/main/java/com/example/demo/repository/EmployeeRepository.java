package com.example.demo.repository;

import com.example.demo.model.Contract;
import com.example.demo.model.Employee;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
    @Query(value = "select * " +
            "from employee c " +
            "where concat(c.employee_email,c.employee_name ,c.employee_phone,c.employee_salary,c.employee_id) like %?1%",
            nativeQuery = true)
    Page<Employee> findAllInputTex(String keyword, Pageable pageable);
}
