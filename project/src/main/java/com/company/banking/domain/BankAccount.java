package com.company.banking.domain;

import com.company.patterns.observer.Observer;
import com.company.banking.strategy.BankingStrategy;
import com.company.framework.domain.Account;
import com.company.framework.domain.AccountType;
import com.company.framework.domain.AccountEntry;
import lombok.Setter;
@Setter
public abstract class BankAccount extends Account {
    BankingStrategy strategy;
    public BankAccount(String accountNumber, AccountType type) {
        super(accountNumber, type);
    }

    public void addInterest() {
        double interest = this.strategy.calculateInterest(getBalance());
        super.deposit(interest);
    }
    @Override
    public void notifyObserver(AccountEntry entry) {
        for (Observer o : getObservers()) {
            o.update(this, entry);
        }
    }
}
