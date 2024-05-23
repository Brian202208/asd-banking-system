package com.company.banking.domain;

import com.company.framework.domain.Account;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class Customer {
    private String name;
    private String email;
    private String birthdate;
    private Address address;


    public Customer(String name) {
        this.name = name;
    }


}


