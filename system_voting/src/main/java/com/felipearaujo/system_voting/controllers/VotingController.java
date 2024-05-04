package com.felipearaujo.system_voting.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.felipearaujo.system_voting.models.Participant;
import com.felipearaujo.system_voting.services.VotingService;

import io.swagger.v3.oas.annotations.parameters.RequestBody;

@RestController
@RequestMapping("/api/voting")
public class VotingController {

    @Autowired
    private VotingService service;
    
    @PostMapping
    public ResponseEntity<String> vote(@RequestBody Participant participant){
        service.addEvent(participant);
        return ResponseEntity.ok("Vote Sucess");
    }
}
