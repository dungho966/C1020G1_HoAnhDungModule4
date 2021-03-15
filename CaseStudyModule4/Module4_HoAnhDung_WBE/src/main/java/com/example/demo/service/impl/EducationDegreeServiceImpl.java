package com.example.demo.service.impl;

import com.example.demo.model.EducationDegree;
import com.example.demo.repository.EducationDegreeRepository;
import com.example.demo.service.EducationDegreeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EducationDegreeServiceImpl implements EducationDegreeService {
    @Autowired
    private EducationDegreeRepository educationDegreeRepository  ;


    @Override
    public Iterable<EducationDegree> findAllEducationDegree() {
        return educationDegreeRepository.findAll();
    }

    @Override
    public EducationDegree findById(int id) {
        return educationDegreeRepository.findById(id).orElse(null);
    }

    @Override
    public void save(EducationDegree educationDegree) {
        educationDegreeRepository.save(educationDegree) ;
    }

    @Override
    public void remove(int id) {
        educationDegreeRepository.deleteById(id);
    }
}
