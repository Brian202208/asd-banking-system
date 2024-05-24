package com.company.banking.domain;

import com.company.framework.domain.AccountType;

public class CompanyAccount extends BankAccount {
    public CompanyAccount(String accountNumber) {
        super(accountNumber, AccountType.COMPANY);
    }

    @Override
    public AccountType getAccountType() {
        return AccountType.COMPANY;
    }


}
