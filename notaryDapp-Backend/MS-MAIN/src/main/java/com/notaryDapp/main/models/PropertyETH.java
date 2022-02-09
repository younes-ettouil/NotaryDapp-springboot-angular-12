package com.notaryDapp.main.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.transaction.annotation.Transactional;

import javax.validation.constraints.NotNull;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
@Data @NoArgsConstructor
@ToString @AllArgsConstructor
public class PropertyETH {
    private String conservationNumber;
    private String idPurchaseContract;
    private @NotNull Double price;
    private List<String> owners;

    public PropertyETH(Contract contract) {
        this.conservationNumber = contract.getProperty().getConservationNumber();
        this.idPurchaseContract = contract.getId();
        this.price = contract.getPrice();
        this.owners = new ArrayList<String>();
        contract.getBuyers().forEach(buyer -> {
            this.owners.add(Arrays.stream(buyer.toString().replaceAll(",", "=").split("=")).toList().get(1));
        });
    }
}
