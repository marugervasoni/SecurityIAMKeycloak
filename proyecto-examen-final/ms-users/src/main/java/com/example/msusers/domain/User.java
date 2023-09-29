package com.example.msusers.domain;

import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Data
public class User {

    public String id;
    public String username;
    public String email;
    public String firstname;
    public List<Bill> bills;

    public User(String id, String username, String email, String firstname) {
        this.id = id;
        this.username = username;
        this.email = email;
        this.firstname = firstname;
        this.bills = new ArrayList<>();
    }

    public void addBill(Bill bill) {
        if (this.bills == null) {
            this.bills = new ArrayList<>();
        }
        this.bills.add(bill);
    }
}
