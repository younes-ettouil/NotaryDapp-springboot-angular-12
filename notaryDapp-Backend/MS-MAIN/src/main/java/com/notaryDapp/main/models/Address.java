package com.notaryDapp.main.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;

@Data @AllArgsConstructor @NoArgsConstructor
public class Address {
    @NotBlank
    private String address;

    @NotBlank
    private String city;

    @NotBlank
    private String country;
}
