package com.example.demo.service;

import com.example.demo.model.RentType;
import com.example.demo.model.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface RentTypeService {
    Page<RentType> findAllRentType(Pageable pageable);
    RentType findById(int id);
    void save(RentType rentType);
    void remove(int id);
}
