package com.example.withjpa.api.v1.model;

import javax.validation.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CustomerDTO {

    @NotBlank(message = "firstname cannot be blank")
    private String firstname;
    @NotBlank(message = "secondname cannot be blank")
    private String lastname;

    // when serilize output to JSON
    @JsonProperty("customer_url")
    private String customerUrl;
}