package org.example.hometask;

import com.fasterxml.jackson.annotation.JsonProperty;

public class UpdateRequest {

    @JsonProperty
    private String name;
    @JsonProperty
    private String job;

    public UpdateRequest (String name, String job){
        this.name = name;
        this.job = job;
    }

}
