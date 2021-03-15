package com.example.demo.service.impl;

import com.example.demo.model.Division;
import com.example.demo.repository.DivisionRepository;
import com.example.demo.service.DivisionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

@Service
public class DivisionServiceImpl implements DivisionService {
    @Autowired
    private DivisionRepository divisionRepository ;
    @Override
    public Iterable<Division> findAllDivision() {
        return divisionRepository.findAll();
    }

    @Override
    public Division findById(int id) {
        return divisionRepository.findById(id).orElse(null);
    }

    @Override
    public void save(Division division) {
        divisionRepository.save(division) ;
    }

    @Override
    public void remove(int id) {
        divisionRepository.deleteById(id);
    }
}
