package com.felipearaujo.system_voting.repository;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.felipearaujo.system_voting.models.Participant;

public interface ParticipantRepository extends MongoRepository<Participant, String>{
    
    Optional<Participant> findByName (String name);
}
