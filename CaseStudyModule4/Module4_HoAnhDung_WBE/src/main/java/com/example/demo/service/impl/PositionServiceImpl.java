package com.example.demo.service.impl;

import com.example.demo.model.Position;
import com.example.demo.repository.PositionRepository;
import com.example.demo.service.PositionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class PositionServiceImpl implements PositionService {
    @Autowired
    private PositionRepository positionRepository ;

    @Override
    public Page<Position> findAllPosition(Pageable pageable) {
        return positionRepository.findAll(pageable);
    }

    @Override
    public Position findById(int id) {
        return positionRepository.findById(id).orElse(null);
    }

    @Override
    public void save(Position position) {
        positionRepository.save(position) ;
    }

    @Override
    public void remove(int id) {
        positionRepository.deleteById(id);
    }
}
