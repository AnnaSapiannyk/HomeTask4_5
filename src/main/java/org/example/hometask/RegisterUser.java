package org.example.hometask;

import com.fasterxml.jackson.annotation.JsonProperty;

public class RegisterUser {

    @JsonProperty
    private String email;
    @JsonProperty
    private String password;

    public RegisterUser (String email, String password){
        this.email = email;
        this.password = password;
    }
}
