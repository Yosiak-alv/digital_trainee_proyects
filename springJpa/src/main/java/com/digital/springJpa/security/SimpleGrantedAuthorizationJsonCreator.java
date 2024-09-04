package com.digital.springJpa.security;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public abstract class SimpleGrantedAuthorizationJsonCreator {
    @JsonCreator
    public SimpleGrantedAuthorizationJsonCreator(@JsonProperty("authority") String role) {
    }
}
