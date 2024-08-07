package org.example.pojo;

import com.fasterxml.jackson.annotation.JsonProperty;

public class CreateUserBody {

    @JsonProperty
    private String name;
    @JsonProperty
    private String job;

    public CreateUserBody(String name, String job) {
        this.name = name;
        this.job = job;
    }
}
