package com.example.demo.service;

import com.example.demo.model.Employee;
import com.example.demo.model.Position;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface PositionService  {
    Page<Position> findAllPosition(Pageable pageable);
    Position findById(int id);
    void save(Position position);
    void remove(int id);
}
