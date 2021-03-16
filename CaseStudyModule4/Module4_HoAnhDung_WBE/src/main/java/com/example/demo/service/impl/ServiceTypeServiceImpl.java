package com.example.demo.service.impl;

import com.example.demo.model.ServiceType;
import com.example.demo.repository.ServiceTypeRepository;
import com.example.demo.service.ServiceTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class ServiceTypeServiceImpl implements ServiceTypeService {
    @Autowired
    private ServiceTypeRepository serviceTypeRepository ;
    @Override
    public Page<ServiceType> findAllServiceType(Pageable pageable) {
        return serviceTypeRepository.findAll(pageable);
    }

    @Override
    public ServiceType findById(int id) {
        return serviceTypeRepository.findById(id).orElse(null);
    }

    @Override
    public void save(ServiceType serviceType) {
            serviceTypeRepository.save(serviceType);
    }

    @Override
    public void remove(int id) {
        serviceTypeRepository.deleteById(id);
    }
}
