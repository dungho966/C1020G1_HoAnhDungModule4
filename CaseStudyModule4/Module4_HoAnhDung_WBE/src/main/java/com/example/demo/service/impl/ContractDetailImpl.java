package com.example.demo.service.impl;

import com.example.demo.model.ContractDetail;
import com.example.demo.repository.ContractDetailRepository;
import com.example.demo.service.ContractDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class ContractDetailImpl implements ContractDetailService {
    @Autowired
    private ContractDetailRepository contractDetailRepository ;
    @Override
    public Page<ContractDetail> findAllContractDetail(Pageable pageable) {
        return contractDetailRepository.findAll(pageable);
    }

    @Override
    public ContractDetail findById(int id) {
        return contractDetailRepository.findById(id).orElse(null);
    }

    @Override
    public void save(ContractDetail contractDetail) {
        contractDetailRepository.save(contractDetail);
    }

    @Override
    public void remove(int id) {
        contractDetailRepository.deleteById(id);
    }
}
