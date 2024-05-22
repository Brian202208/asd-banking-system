package com.company.core.bankaccount;

import com.company.core.domain.AccountType;

public class PersonalAccount extends BankAccount{
    public PersonalAccount(String accountNumber, AccountType type) {
        super(accountNumber, type);
    }
}
