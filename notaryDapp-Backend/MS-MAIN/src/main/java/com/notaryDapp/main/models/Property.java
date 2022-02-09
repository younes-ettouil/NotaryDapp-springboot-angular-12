package com.notaryDapp.main.models;

import com.notaryDapp.main.models.emuns.PropertyType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

@Data @AllArgsConstructor @NoArgsConstructor
public class Property {
    @NotNull
    private PropertyType type;

    @NotNull
    private String conservationNumber;

    @NotNull
    private Double surface;

    @NotNull
    private Boolean taxesFree;

    @Valid
    private Address address;
}
