package com.example.demo.repository;

import com.example.demo.model.ContractDetail;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ContractDetailRepository extends JpaRepository<ContractDetail , Integer> {
}