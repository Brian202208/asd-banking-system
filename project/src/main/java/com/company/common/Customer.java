package com.company.common;

import com.company.framework.domain.Account;
import lombok.Data;

import java.io.Serial;
import java.io.Serializable;

@Data
public class Customer implements Serializable {


    @Serial
    private static final long serialVersionUID = -8183274566688504374L;

    private String name;
    private String email;
    private String birthdate;
    private Address address;


    public Customer(String name) {
        this.name = name;
    }


}


