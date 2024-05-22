package com.company.core.bankaccount;

import com.company.core.domain.AccountEntry;
import com.company.core.domain.AccountType;
import com.company.core.observer.Observer;

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
