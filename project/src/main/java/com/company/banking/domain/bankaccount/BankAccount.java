package com.company.banking.domain.bankaccount;

import com.company.banking.strategy.BankingStrategy;
import com.company.banking.domain.Account;
import com.company.common.AccountType;
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
}
