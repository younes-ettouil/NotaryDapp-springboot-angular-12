package com.notaryDapp.main.controllers;

import com.notaryDapp.main.models.Contract;
import com.notaryDapp.main.services.ContractService;
import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Lazy;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import javax.validation.Valid;
import java.util.Date;
import java.util.List;
//@CrossOrigin(origins = "*")
@RestController @AllArgsConstructor
@RequestMapping("/api")
public class ContractController {

    private ContractService contractService;



    @PostMapping("/contract")
    Contract store(@Valid @RequestBody Contract contract) throws Exception{
        return this.contractService.store(contract);
    }

//    @GetMapping("/contract")
//    List<Contract> getAll(){
//        return this.contractService.getAll();
//    }

    @GetMapping("/contract/{id}")
    Contract getById(@PathVariable String id){
        return this.contractService.getById(id);
    }

    @GetMapping("/contract")
    List<Contract> getByDateAfter(@RequestParam("from") @DateTimeFormat(pattern = "yyyy-MM-dd") Date from){
        return this.contractService.getByDateAfter(from);
    }

    @GetMapping("/contract/date")
    List<Contract> getByDateInterval(@RequestParam("from") @DateTimeFormat(pattern = "yyyy-MM-dd") Date from, @RequestParam("to") @DateTimeFormat(pattern = "yyyy-MM-dd") Date to){
        return this.contractService.getByDateInterval(from, to);
    }
}
