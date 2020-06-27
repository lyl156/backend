package com.example.withjpa.api.v1.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CustomerDTO {
    private String firstname;
    private String lastname;

    // when serilize output to JSON
    @JsonProperty("customer_url")
    private String customerUrl;
}