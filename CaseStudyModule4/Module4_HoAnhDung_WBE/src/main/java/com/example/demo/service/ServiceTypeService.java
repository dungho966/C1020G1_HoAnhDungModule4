package com.example.demo.service;

import com.example.demo.model.Service;
import com.example.demo.model.ServiceType;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ServiceTypeService {
    Page<ServiceType> findAllServiceType(Pageable pageable);
    ServiceType findById(int id);
    void save(ServiceType serviceType);
    void remove(int id);
}
