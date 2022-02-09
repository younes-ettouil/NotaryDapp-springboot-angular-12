package com.notaryDapp.main.models;

import com.notaryDapp.main.models.emuns.CustumerType;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class Entreprise extends Customer{
    private String tradeRegistry;
    private String headOffice;
    private Double capital;
    private Individual representative;

    @Builder
    public Entreprise(String wallet, CustumerType custumerType, Address address, String phone, String tradeRegistry, String headOffice, Double capital, Individual representative) {
        super(wallet, custumerType, address, phone);
        this.tradeRegistry = tradeRegistry;
        this.headOffice = headOffice;
        this.capital = capital;
        this.representative = representative;
    }

}
