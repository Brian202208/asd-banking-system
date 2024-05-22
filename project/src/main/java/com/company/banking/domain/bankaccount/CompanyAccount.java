package com.company.banking.domain.bankaccount;

import com.company.banking.AccountStrategyType;
import com.company.banking.domain.AccountEntry;
import com.company.banking.domain.AccountType;
import com.company.banking.observer.Observer;

public class CompanyAccount extends BankAccount {
    public CompanyAccount(String accountNumber) {
        super(accountNumber, AccountType.COMPANY);
    }

    @Override
    public AccountType getAccountType() {
        return AccountType.COMPANY;
    }

    @Override
    public void notifyObserver(AccountEntry entry) {
        for (Observer o : getObservers()) {
            o.update(this, entry);
        }
    }

}
