package com.notaryDapp.eth.services;

import com.notaryDapp.eth.contratcs.PropertyContract;
import com.notaryDapp.eth.models.Property;
import lombok.Data;
import org.springframework.stereotype.Service;
import org.web3j.crypto.Credentials;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.http.HttpService;

import java.math.BigInteger;

@Service @Data
public class PropertyService {

    private final static BigInteger GAS_LIMIT = BigInteger.valueOf(6721975L);
    private final static BigInteger GAS_PRICE = BigInteger.valueOf(20000000000L);

    private static String CONTRACT_ADDRESS = "0xF7CfbB90eAC9075De9F9447a69225Ec27235FD4B";
    private String PRIVATE_KEY="a2e6b036a7be66f4b5f6d471205e1fc64efeaeecb171c1a1212c762d341ff91a";

    private Web3j web3j;
    private  Credentials credentials;

    public PropertyService() {
        this.web3j = Web3j.build(new HttpService());
        this.credentials = Credentials.create(PRIVATE_KEY);
    }

    public boolean addProperty(Property property) throws Exception {
        if (property != null) {
            Web3j web3j = Web3j.build(new HttpService());
            Credentials credentials = Credentials.create(PRIVATE_KEY);
            PropertyContract propertyContract = PropertyContract.load(CONTRACT_ADDRESS, web3j, credentials, GAS_PRICE, GAS_LIMIT);
            return propertyContract.createProperty(property.getConservationNumber(), property.getIdPurchaseContract(), property.getPrice(), property.getOwners()).send().isStatusOK();
        }
        return false;
    }

    public Property getProperty(String conservationNumber) throws Exception {
        if (conservationNumber != null) {
            Web3j web3j = Web3j.build(new HttpService());
            Credentials credentials = Credentials.create(PRIVATE_KEY);
            PropertyContract propertyContract = PropertyContract.load(CONTRACT_ADDRESS, web3j, credentials, GAS_PRICE, GAS_LIMIT);
            return new Property(propertyContract.properties(conservationNumber).send(), propertyContract.getOwners(conservationNumber).send());
        }
        return null;
    }
}
