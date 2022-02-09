package com.notaryDapp.eth.controllers;

import com.notaryDapp.eth.models.Property;
import com.notaryDapp.eth.services.PropertyService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/eth")
@AllArgsConstructor
@Slf4j
public class PropertyContoller {

    private PropertyService propertyService;

    @PostMapping("/property")
    Boolean store(@Valid @RequestBody Property property) throws Exception{
        return this.propertyService.addProperty(property);
    }

    @GetMapping("/property/{conservationNumber}")
    Property get(@PathVariable String conservationNumber) throws Exception{
        return this.propertyService.getProperty(conservationNumber);
    }

    @GetMapping("/private-key/{privateKey}")
    Boolean privateKey(@Valid @PathVariable String privateKey) {
        log.info("Private key was updated : " + privateKey);
        this.propertyService.setPRIVATE_KEY(privateKey);
        return this.propertyService.getPRIVATE_KEY().equals(privateKey);
    }

    @GetMapping("/private-key")
    String getPrivateKey() {
        return this.propertyService.getPRIVATE_KEY();
    }
}
