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

    private List<Account> accountList;

    public Customer(String name) {
        this.name = name;
        this.accountList = new ArrayList<>();
    }

    public void addAccount(Account acc) {
        this.accountList.add(acc);
    }


}


