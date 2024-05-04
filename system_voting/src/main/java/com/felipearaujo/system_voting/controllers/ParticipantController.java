package com.felipearaujo.system_voting.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.felipearaujo.system_voting.models.Participant;
import com.felipearaujo.system_voting.services.ParticipantService;

@RestController
@RequestMapping("/api/participants")
public class ParticipantController {
    

    @Autowired
    private ParticipantService service;

    @PostMapping("/save")
    public ResponseEntity<Object> save(@RequestBody Participant participant){
        var save = service.save(participant);
        return ResponseEntity.ok(save);
    }

    @GetMapping("/consult")
    public ResponseEntity<Object> consult(@RequestParam String id){
        var consult = service.consult(id);
        return ResponseEntity.ok(consult);
    }
}
