package com.company.creditcard.domain;

import com.company.banking.domain.Account;
import com.company.common.AccountType;


public class CreditCardAccount extends Account {
    public CreditCardAccount(String accountNumber) {
        super(accountNumber, AccountType.CREDIT);
    }


    @Override
    public AccountType getAccountType() {
        return AccountType.CREDIT;
    }

    @Override
    public void addInterest() {

    }
}
