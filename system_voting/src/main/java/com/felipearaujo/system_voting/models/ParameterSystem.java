package com.felipearaujo.system_voting.models;

import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document("parameters")
public class ParameterSystem {

    private String key;
    private String value;
    
}
