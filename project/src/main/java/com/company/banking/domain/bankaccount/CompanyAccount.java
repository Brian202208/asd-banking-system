package com.company.banking.domain.bankaccount;

import com.company.framework.domain.AccountEntry;
import com.company.common.AccountType;
import com.company.banking.observer.Observer;

public class CompanyAccount extends BankAccount {
    public CompanyAccount(String accountNumber) {
        super(accountNumber, AccountType.COMPANY);
    }

    @Override
    public AccountType getAccountType() {
        return AccountType.COMPANY;
    }


}
