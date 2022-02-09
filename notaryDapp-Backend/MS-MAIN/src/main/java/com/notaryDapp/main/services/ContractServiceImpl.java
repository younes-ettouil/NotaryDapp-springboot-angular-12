package com.notaryDapp.main.services;

import com.notaryDapp.main.models.Contract;
import com.notaryDapp.main.models.PropertyETH;
import com.notaryDapp.main.openFeign.ETHController;
import com.notaryDapp.main.repositories.ContractRepository;
import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

@Service
@Transactional
@AllArgsConstructor
public class ContractServiceImpl implements ContractService {

    private ContractRepository contractRepository;
    private ETHController ethController;

    @Override
    public Contract store(Contract contract) {
        Contract contract1 = this.contractRepository.insert(contract);
        /*STORE IN ETH*/
        ethController.store(
            new PropertyETH(contract1)
        );
        return contract1;
    }

    @Override
    public List<Contract> getAll() {
        return this.contractRepository.findAll();
    }

    @Override
    public Contract getById(String id) {
        return this.contractRepository.findById(id).get();
    }

    @Override
    public List<Contract> getByDateAfter(Date date) {
        return this.contractRepository.findAllByDateAfter(date);
    }

    @Override
    public List<Contract> getByDateInterval(Date date1, Date date2) {
        return this.contractRepository.findAllByDateBetween(date1, date2);
    }
}
