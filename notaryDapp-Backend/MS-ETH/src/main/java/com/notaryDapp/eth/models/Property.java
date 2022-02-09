package com.notaryDapp.eth.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.web3j.tuples.generated.Tuple3;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.math.BigInteger;
import java.util.List;

@Data @AllArgsConstructor @NoArgsConstructor @ToString
public class Property {
    @NotNull
    private String conservationNumber;
    @NotNull
    private String idPurchaseContract;
    @NotNull
    private BigInteger price;
    @NotEmpty
    private List<String> owners;

    public Property(Tuple3<String, String, BigInteger> tuple3, List<String> owners) {
        this.conservationNumber = tuple3.component1();
        this.idPurchaseContract = tuple3.component2();
        this.price = tuple3.component3();
        this.owners = owners;
    }
}
