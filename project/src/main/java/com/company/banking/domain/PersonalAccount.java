package com.company.banking.domain;

import com.company.framework.domain.AccountEntry;
import com.company.framework.domain.AccountType;
import com.company.patterns.observer.Observer;

public class PersonalAccount extends BankAccount {

    public PersonalAccount(String accountNumber) {
        super(accountNumber, AccountType.PERSONAL);
    }

    @Override
    public AccountType getAccountType() {
        return AccountType.PERSONAL;
    }

    @Override
    public void notifyObserver(AccountEntry accountEntry) {
        if (shouldSendEmail(accountEntry)) {
            for (Observer o : getObservers()) {
                o.update(this, accountEntry);
            }
        }
    }

    private boolean shouldSendEmail(AccountEntry accountEntry) {
        return accountEntry.getAmount() > 500
                || accountEntry.getAmount() < -500
                || this.getBalance()  < 0;
    }
}
