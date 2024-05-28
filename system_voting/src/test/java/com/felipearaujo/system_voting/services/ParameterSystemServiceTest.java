package com.felipearaujo.system_voting.services;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoInteractions;
import static org.mockito.Mockito.when;

import java.util.Optional;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.felipearaujo.system_voting.models.ParameterSystem;
import com.felipearaujo.system_voting.repository.ParameterSystemRepository;
import com.felipearaujo.system_voting.services.business_exception.BadRequestException;
import com.felipearaujo.system_voting.services.business_exception.NotFoundException;

public class ParameterSystemServiceTest {

    @InjectMocks
    private ParameterSystemService service;

    @Mock
    private ParameterSystemRepository repository;

    @BeforeEach
    void setup() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    @DisplayName("The parameter must be saved successfully, when everything is OK")
    void testSaveCase1() {

        ParameterSystem parameter = new ParameterSystem("1", "vote");

        when(repository.save(parameter)).thenReturn(parameter);
        service.save(parameter);
        verify(repository, times(1)).save(parameter);

    }

    @Test
    @DisplayName("Do not save if key or value is null")
    void testSaveCase2() throws BadRequestException {

        ParameterSystem parameter = new ParameterSystem("3", null);

        when(repository.save(parameter)).thenReturn(parameter);

        BadRequestException thrown = Assertions.assertThrows(BadRequestException.class, () -> {
            service.save(parameter);
        });

        Assertions.assertEquals("Key or Value field cannot be null or empty", thrown.getMessage());

        verifyNoInteractions(repository);
    }

    @Test
    @DisplayName("Do not save if key or value is empty")
    void testSaveCase3() throws BadRequestException {

        ParameterSystem parameter = new ParameterSystem("", "SOS");

        when(repository.save(parameter)).thenReturn(parameter);

        BadRequestException thrown = Assertions.assertThrows(BadRequestException.class, () -> {
            service.save(parameter);
        });

        Assertions.assertEquals("Key or Value field cannot be null or empty", thrown.getMessage());

        verifyNoInteractions(repository);
    }

    @Test
    @DisplayName("The query returns success when searching for the key, OK")
    void testeConsultCase1() {
        
        ParameterSystem parameter = new ParameterSystem("5", "Voting");

        when(repository.findById(parameter.getKey())).thenReturn(Optional.of(parameter));

        Optional.of(service.consult(parameter.getKey()));

        assertEquals(parameter, parameter);
        verify(repository, times(1)).findById(parameter.getKey());

    }

    @Test
    @DisplayName("If you search the database and don't find a parameter, you need to return the exception")
    void testeConsultCase2() throws NotFoundException{
        
        ParameterSystem parameter = new ParameterSystem("7", "Vote");

        when(repository.findById(parameter.getKey())).thenReturn(Optional.empty());

        NotFoundException thrown = Assertions.assertThrows(NotFoundException.class, () -> {
            service.consult(parameter.getKey());
        });

        Assertions.assertEquals("Parameter not found ", thrown.getMessage());

        verify(repository, times(1)).findById(parameter.getKey());
    }

    @Test
    @DisplayName("Throws an exception if the key value is empty")
    void testeConsultCase3() throws BadRequestException{
        
        ParameterSystem parameter = new ParameterSystem("", "Air");

        when(repository.findById(parameter.getKey())).thenReturn(Optional.of(parameter));

        BadRequestException thrown = Assertions.assertThrows(BadRequestException.class, () -> {
            service.consult(parameter.getKey());
        });

        Assertions.assertEquals("The key cannot be empty", thrown.getMessage());

        verifyNoInteractions(repository);
    }

}

