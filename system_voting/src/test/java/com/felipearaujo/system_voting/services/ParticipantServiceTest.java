package com.felipearaujo.system_voting.services;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoInteractions;
import static org.mockito.Mockito.when;

import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.felipearaujo.system_voting.models.Participant;
import com.felipearaujo.system_voting.repository.ParticipantRepository;
import com.felipearaujo.system_voting.services.business_exception.BadRequestException;

public class ParticipantServiceTest {
    
    @InjectMocks
    private ParticipantService service;

    @Mock
    private ParticipantRepository repository;

    @BeforeEach
    void setup() {
        MockitoAnnotations.openMocks(this);
    }
    
    @Test
    @DisplayName("The parameter must be saved successfully, when everything is OK")
    void testSaveCase1() {
        
        Participant participant = new Participant("1","Felipe");

        when(repository.save(participant)).thenReturn(participant);
        service.save(participant);
        verify(repository, times(1)).save(participant);
    }

    @Test
    @DisplayName("An exception should be thrown if some information is not expected from the type string name")
    void testSaveCase2() {
        
        Participant participant = new Participant("1","");

        BadRequestException thrown = assertThrows(BadRequestException.class, () -> {
            service.save(participant);
        });

        assertEquals("Participant name cannot be null or empty", thrown.getMessage());

        verifyNoInteractions(repository);
    }

    @Test
    @DisplayName("An exception should be thrown if some information is not expected from the type string id")
    void testSaveCase3() {
        
        Participant participant = new Participant("","Felipe");

        BadRequestException thrown = assertThrows(BadRequestException.class, () -> {
            service.save(participant);
        });

        assertEquals("Participant id cannot be null or empty", thrown.getMessage());

        verifyNoInteractions(repository);
    }

    @Test
    @DisplayName("An exception must be thrown if the same name already exists saved in the database")
    void testSaveCase4() {
        
        Participant participant = new Participant("1","Felipe");

        when(repository.findByName(participant.getName())).thenReturn(Optional.of(participant));

        BadRequestException thrown = assertThrows(BadRequestException.class, () -> {
            service.save(participant);
        });

        assertEquals("Participant with this name already exists", thrown.getMessage());

        verify(repository, times(1)).findByName(participant.getName());
    }


    @Test
    @DisplayName("")
    void testConsult() {

    }
}
