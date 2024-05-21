package com.company.core.bankaccount;

import com.company.core.domain.AccountType;

public class CompanyAccount extends BankAccount{
    public CompanyAccount(String accountNumber, AccountType type) {
        super(accountNumber, type);
    }
}
