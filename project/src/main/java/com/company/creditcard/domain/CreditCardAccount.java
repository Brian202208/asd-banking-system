package com.company.creditcard.domain;

import com.company.banking.AccountStrategyType;
import com.company.banking.domain.Account;
import com.company.banking.domain.AccountType;


public class CreditCardAccount extends Account {
    public CreditCardAccount(String accountNumber) {
        super(accountNumber, AccountType.CREDIT);
    }

    @Override
    public AccountStrategyType getAccountStrategy() {
        return null;
    }

    @Override
    public AccountType getAccountType() {
        return null;
    }
}
