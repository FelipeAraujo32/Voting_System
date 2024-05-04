package com.felipearaujo.system_voting.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.felipearaujo.system_voting.models.Participant;

public interface ParticipantRepository extends MongoRepository<Participant, String>{
    
}
