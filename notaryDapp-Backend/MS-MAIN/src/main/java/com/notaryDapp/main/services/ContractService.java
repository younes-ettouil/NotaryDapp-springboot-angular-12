package com.notaryDapp.main.services;

import com.notaryDapp.main.models.Contract;

import java.util.Date;
import java.util.List;

public interface ContractService {
    Contract store(Contract contract);
    List<Contract> getAll();
    Contract getById(String id);
    List<Contract> getByDateAfter(Date date);
    List<Contract> getByDateInterval(Date date1, Date date2);
}
