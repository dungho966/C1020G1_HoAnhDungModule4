package com.example.demo.service.impl;

import com.example.demo.model.AttackService;
import com.example.demo.repository.AttackServiceRepository;
import com.example.demo.service.AttackServiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class AttackServiceImpl implements AttackServiceService {
    @Autowired
    private AttackServiceRepository attackServiceRepository;
    @Override
    public Page<AttackService> findAllAttackService(Pageable pageable) {
        return attackServiceRepository.findAll(pageable) ;
    }

    @Override
    public AttackService findById(int id) {
        return attackServiceRepository.findById(id).orElse(null);
    }

    @Override
    public void save(AttackService attackService) {
            attackServiceRepository.save(attackService);
    }

    @Override
    public void remove(int id) {
        attackServiceRepository.deleteById(id);
    }
}
