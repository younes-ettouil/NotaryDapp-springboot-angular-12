package com.notaryDapp.main.models;

import com.notaryDapp.main.models.emuns.CustumerType;
import com.notaryDapp.main.models.emuns.Gender;
import com.notaryDapp.main.models.emuns.IdentityDoc;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter @Setter
public class Individual extends Customer{
    private String fullNAme;
    private Gender gender;
    private IdentityDoc identityDoc;
    private String identityCode;
    private String nationality;
    private Date birthday;
    private String placeOfBirth;

    @Builder
    public Individual(String wallet, CustumerType custumerType, Address address, String phone, String fullNAme, Gender gender, IdentityDoc identityDoc, String identityCode, String nationality, Date birthday, String placeOfBirth) {
        super(wallet, custumerType, address, phone);
        this.fullNAme = fullNAme;
        this.gender = gender;
        this.identityDoc = identityDoc;
        this.identityCode = identityCode;
        this.nationality = nationality;
        this.birthday = birthday;
        this.placeOfBirth = placeOfBirth;
    }
}
