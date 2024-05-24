package com.felipearaujo.system_voting.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.felipearaujo.system_voting.models.ParameterSystem;
import com.felipearaujo.system_voting.services.ParameterSystemService;

@RestController
@RequestMapping("/api/parameters")
public class ParameterSystemController {

    @Autowired
    ParameterSystemService service;

    @PostMapping("/save")
    public ResponseEntity<Object> save(@RequestBody ParameterSystem parameterSystem) {
        var save = service.save(parameterSystem);
        return ResponseEntity.ok(save);
    }

    @GetMapping("/consult")
    public ResponseEntity<Object> consult(@RequestParam String key) {
        var consult = service.consult(key);
        return ResponseEntity.ok(consult);
    }
}
