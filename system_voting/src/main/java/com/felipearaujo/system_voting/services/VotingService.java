package com.felipearaujo.system_voting.services;

import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import com.felipearaujo.system_voting.models.Participant;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class VotingService {

    private static final String TOPIC_VOTING = "voting";
    
    private final KafkaTemplate<Object, Object> template;

    public void addEvent(Participant participant){
        template.send(TOPIC_VOTING, participant);
    }
}
