package com.notaryDapp.main.repositories;

import com.notaryDapp.main.models.Contract;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Date;
import java.util.List;


public interface ContractRepository extends MongoRepository<Contract, String> {
    List<Contract> findAllByDateAfter(Date date);
    List<Contract> findAllByDateBetween(Date date1, Date date2);
}
