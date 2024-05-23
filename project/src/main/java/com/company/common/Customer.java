package com.company.common;

import lombok.Data;

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


