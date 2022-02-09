package com.notaryDapp.main.models;

import com.notaryDapp.main.models.emuns.CustumerType;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data @AllArgsConstructor
public abstract class Customer {
    private String wallet;
    private CustumerType custumerType;
    private Address address;
    private String phone;
}
