package com.notaryDapp.main.models;

import com.notaryDapp.main.models.emuns.ContractType;
import com.notaryDapp.main.models.emuns.PaymentMethod;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.bson.codecs.jsr310.LocalDateCodec;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@Document
@Data @AllArgsConstructor
public class Contract {
    @Id
    private String id;

    @NotNull
    private ContractType type;

    private LocalDate date;

    @NotNull
    private Double price;

    @NotNull
    private PaymentMethod paymentMethod;

    @NotEmpty
    private List<Object> sellers;

    @NotEmpty
    private List<Object> buyers;

    @Valid
    private Property property;

    public Contract() {
        this.date = (this.date == null ? LocalDate.now() : this.getDate());
    }
}
