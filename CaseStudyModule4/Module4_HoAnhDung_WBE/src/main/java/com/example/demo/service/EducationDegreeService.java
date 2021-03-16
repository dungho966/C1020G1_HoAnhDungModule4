package com.example.demo.service;

import com.example.demo.model.Division;
import com.example.demo.model.EducationDegree;

public interface EducationDegreeService {
    Iterable<EducationDegree> findAll();

    EducationDegree findById(int id);

    void save(EducationDegree educationDegree);

    void remove(int id);
}
