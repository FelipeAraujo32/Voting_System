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
import com.felipearaujo.system_voting.services.Business_exception.BadRequestException;

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
    void testeConsultCasa1() {
        // Está retornado o valor direto, preciso olha o erro.
        ParameterSystem parameter = new ParameterSystem("5", "Voting");

        when(repository.findById(parameter.getKey())).thenReturn(Optional.of(parameter));

        Optional<ParameterSystem> opt = Optional.of(service.consult(parameter.getKey()));

        assertEquals(Optional.of(parameter), parameter);
        verify(repository, times(1)).findById(parameter.getKey());

    }

}
