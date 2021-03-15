package com.example.demo.service;

import com.example.demo.model.Division;

public interface DivisionService {
    Iterable<Division> findAllDivision();

    Division findById(int id);

    void save(Division division);

    void remove(int id);
}
