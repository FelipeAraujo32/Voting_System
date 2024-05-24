package com.felipearaujo.system_voting.repository;


import org.springframework.data.mongodb.repository.MongoRepository;

import com.felipearaujo.system_voting.models.ParameterSystem;

public interface ParameterSystemRepository  extends MongoRepository<ParameterSystem, String>{  
 
}
