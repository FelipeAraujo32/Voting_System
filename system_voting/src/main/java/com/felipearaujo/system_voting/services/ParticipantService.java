package com.felipearaujo.system_voting.services;


import java.util.Optional;

import org.apache.coyote.BadRequestException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.felipearaujo.system_voting.models.Participant;
import com.felipearaujo.system_voting.repository.ParticipantRepository;
import com.felipearaujo.system_voting.services.Business_exception.NotFoundException;

@Service
public class ParticipantService {

    @Autowired
    private ParticipantRepository repository;

    public Participant save(Participant participant) throws BadRequestException{
        
        Optional<Participant> optParticipant = repository.findByName(participant.getName());

        if(optParticipant.isPresent()){
            throw new BadRequestException("Participant with this name already exists");
        }
        return repository.save(participant);
    }

    public Participant consult(String id){
        return repository.findById(id)
            .orElseThrow(() -> new NotFoundException("Participant not found "));
    }
    
}
