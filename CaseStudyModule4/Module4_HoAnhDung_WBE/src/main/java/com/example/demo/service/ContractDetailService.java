package com.example.demo.service;

import com.example.demo.model.Contract;
import com.example.demo.model.ContractDetail;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ContractDetailService {
    Page<ContractDetail> findAllContractDetail(Pageable pageable);
    ContractDetail findById(int id);
    void save(ContractDetail contractDetail);
    void remove(int id);
}
