package com.felipearaujo.system_voting.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.felipearaujo.system_voting.models.ParameterSystem;
import com.felipearaujo.system_voting.repository.ParameterSystemRepository;

@Service
public class ParameterSystemService {

    @Autowired
    private ParameterSystemRepository repository;



    public ResponseEntity<ParameterSystem> save(ParameterSystem parameterSystem){
        return ResponseEntity.ok(repository.save(parameterSystem));
    }

    public ResponseEntity<ParameterSystem> consult(String key){
        Optional<ParameterSystem> optParameter = repository.findById(key);
        if (optParameter.isEmpty()){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(optParameter.get());
    }
}
