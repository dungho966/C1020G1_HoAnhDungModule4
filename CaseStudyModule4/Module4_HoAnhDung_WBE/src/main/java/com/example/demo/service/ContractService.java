package com.example.demo.service;

import com.example.demo.model.Contract;
import com.example.demo.model.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ContractService {
    Page<Contract> findAllContract(Pageable pageable);
    Contract findById(int id);
    void save(Contract contract);
    void remove(int id);
}
