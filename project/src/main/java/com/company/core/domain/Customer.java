package com.company.core.domain;

import java.util.ArrayList;
import java.util.List;

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

    public List<Account> getAccountList() {
        return accountList;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public String getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(String birthdate) {
        this.birthdate = birthdate;
    }
}


