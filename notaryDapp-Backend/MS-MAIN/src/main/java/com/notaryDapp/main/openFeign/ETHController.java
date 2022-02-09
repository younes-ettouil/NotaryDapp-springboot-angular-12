package com.notaryDapp.main.openFeign;

import com.notaryDapp.main.models.PropertyETH;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import javax.validation.Valid;

@FeignClient(name = "MS-ETH")
public interface ETHController {

    @PostMapping(path = "/eth/property")
    Boolean store(@RequestBody PropertyETH propertyETH);

//    @GetMapping(path = "/eth/property/{conservationNumber}")
//    PropertyETH get(@PathVariable String conservationNumber);
}
