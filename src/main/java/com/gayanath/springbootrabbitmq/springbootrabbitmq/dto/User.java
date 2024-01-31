package com.gayanath.springbootrabbitmq.springbootrabbitmq.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class User {

    private int id;
    private String firstName;
    private String lastName;
}
