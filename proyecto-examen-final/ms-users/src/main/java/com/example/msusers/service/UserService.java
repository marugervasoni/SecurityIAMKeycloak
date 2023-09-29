package com.example.msusers.service;

import com.example.msusers.domain.Bill;
import com.example.msusers.domain.User;
import com.example.msusers.repository.BillsRepository;
import com.example.msusers.repository.FeignBillsRepository;
import com.example.msusers.repository.KeycloakUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class UserService {

    @Autowired
    private KeycloakUserRepository userRepository;
    @Autowired
    private BillsRepository billsRepository;

    public UserService(KeycloakUserRepository userRepository, BillsRepository billsRepository) {
        this.userRepository = userRepository;
        this.billsRepository = billsRepository;
    }

    public User findById(String id){
        User user = userRepository.findById(id);
        List<Bill> bills = billsRepository.findBillsByUserId(id);
        if (user != null)
            user.setBills(bills);

        return user;
    }
}
