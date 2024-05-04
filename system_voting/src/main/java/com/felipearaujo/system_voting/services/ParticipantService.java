package com.felipearaujo.system_voting.services;


import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.felipearaujo.system_voting.models.Participant;
import com.felipearaujo.system_voting.repository.ParticipantRepository;

@Service
public class ParticipantService {

    @Autowired
    private ParticipantRepository repository;

    public ResponseEntity<Participant> save(Participant participant){
        return ResponseEntity.ok(repository.save(participant));
    }

    public ResponseEntity<Participant> consult(String id){
        Optional<Participant> optParameter = repository.findById(id);
        if (optParameter.isEmpty()){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(optParameter.get());
    }
    
}
