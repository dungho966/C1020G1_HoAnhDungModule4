package com.example.demo.service;

import com.example.demo.model.Position;
import com.example.demo.model.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ServiceService {
    Page<Service> findAllService(Pageable pageable);
    Service findById(int id);
    void save(Service service);
    void remove(int id);
}
