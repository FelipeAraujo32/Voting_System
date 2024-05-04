package com.felipearaujo.system_voting.repository;


import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.felipearaujo.system_voting.models.ParameterSystem;


@Repository
public interface ParameterSystemRepository  extends MongoRepository<ParameterSystem, String>{
    
}
