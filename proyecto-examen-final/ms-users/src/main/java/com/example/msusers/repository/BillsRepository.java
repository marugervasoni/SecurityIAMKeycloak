package com.example.msusers.repository;

import com.example.msusers.domain.Bill;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class BillsRepository {

    private FeignBillsRepository feignBillsRepository;

    public BillsRepository(FeignBillsRepository feignBillsRepository) {
        this.feignBillsRepository = feignBillsRepository;
    }

    public List<Bill> findBillsByUserId(String id){
        ResponseEntity<List<Bill>> bills = feignBillsRepository.findBillsByUserId(id);
        return bills.getBody();
    }
}
