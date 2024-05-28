package com.felipearaujo.system_voting.services;


import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.felipearaujo.system_voting.models.Participant;
import com.felipearaujo.system_voting.repository.ParticipantRepository;
import com.felipearaujo.system_voting.services.business_exception.BadRequestException;
import com.felipearaujo.system_voting.services.business_exception.NotFoundException;
import com.felipearaujo.system_voting.services.business_exception.ValidationExceptionBusiness;

@Service
public class ParticipantService {

    @Autowired
    private ParticipantRepository repository;

    public Participant save(Participant participant) throws BadRequestException, ValidationExceptionBusiness{
        
            validateParticipant(participant);
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

    public void validateParticipant(Participant participant) throws ValidationExceptionBusiness{
            // preciso fazer retonar O bory na requi.
        if (participant.getName() == null || participant.getName().trim().isEmpty()) {
            throw new ValidationExceptionBusiness("Participant name cannot be null or empty");
        }

        if (participant.getId() == null || participant.getId().trim().isEmpty()) {
            throw new ValidationExceptionBusiness("Participant id cannot be null or empty");
        }    
    
    }
}
