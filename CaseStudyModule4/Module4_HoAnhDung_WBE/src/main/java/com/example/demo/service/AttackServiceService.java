package com.example.demo.service;

import com.example.demo.model.AttackService;
import com.example.demo.model.Contract;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface AttackServiceService {
    Page<AttackService> findAllAttackService(Pageable pageable);
    AttackService findById(int id);
    void save(AttackService attackService);
    void remove(int id);
}
