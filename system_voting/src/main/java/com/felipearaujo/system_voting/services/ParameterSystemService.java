package com.felipearaujo.system_voting.services;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.felipearaujo.system_voting.models.ParameterSystem;
import com.felipearaujo.system_voting.repository.ParameterSystemRepository;
import com.felipearaujo.system_voting.services.Business_exception.BadRequestException;
import com.felipearaujo.system_voting.services.Business_exception.NotFoundException;

@Service
public class ParameterSystemService {

    @Autowired
    private ParameterSystemRepository repository;

    public ParameterSystem save(ParameterSystem parameterSystem) {
        if(parameterSystem.getKey() == null || parameterSystem.getKey().isEmpty() || 
            parameterSystem.getValue() == null || parameterSystem.getValue().isEmpty()) {
            throw new BadRequestException("Key or Value field cannot be null or empty");
        }
        return repository.save(parameterSystem);
    }

    public ParameterSystem consult(String key){
        key = key.trim();
        if (key.isEmpty()) {
            throw new BadRequestException("The key cannot be empty");
        }
        return repository.findById(key)
            .orElseThrow(() -> new NotFoundException("Parameter not found "));


        }
}