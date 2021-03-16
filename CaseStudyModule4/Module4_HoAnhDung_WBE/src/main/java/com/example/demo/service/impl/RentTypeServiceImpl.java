package com.example.demo.service.impl;

import com.example.demo.model.RentType;
import com.example.demo.repository.RentTypeRepository;
import com.example.demo.service.RentTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class RentTypeServiceImpl implements RentTypeService {
    @Autowired
    private RentTypeRepository rentTypeRepository ;
    @Override
    public Page<RentType> findAllRentType(Pageable pageable) {
        return rentTypeRepository.findAll(pageable);
    }

    @Override
    public RentType findById(int id) {
        return findById(id);
    }

    @Override
    public void save(RentType rentType) {
        rentTypeRepository.save(rentType);
    }

    @Override
    public void remove(int id) {
        rentTypeRepository.deleteById(id);
    }
}
