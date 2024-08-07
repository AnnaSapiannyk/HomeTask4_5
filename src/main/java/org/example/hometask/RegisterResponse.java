package org.example.hometask;

import com.fasterxml.jackson.annotation.JsonProperty;

public class RegisterResponse {

    @JsonProperty
    private int id;
    @JsonProperty
    private String token;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
