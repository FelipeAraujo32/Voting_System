package com.felipearaujo.system_voting.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.felipearaujo.system_voting.models.ParameterSystem;
import com.felipearaujo.system_voting.repository.ParameterSystemRepository;
import com.felipearaujo.system_voting.services.Business_exception.NotFoundException;

@Service
public class ParameterSystemService {

    @Autowired
    private ParameterSystemRepository repository;

    public ParameterSystem save(ParameterSystem parameterSystem){
        return repository.save(parameterSystem);
    }

    public ParameterSystem consult(String key){
        return repository.findById(key)
            .orElseThrow(() -> new NotFoundException("Parameter not found "));   
    }
}
