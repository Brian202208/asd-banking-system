package com.company.creditcard.repository;

import com.company.banking.domain.Account;

import java.util.Collection;

public interface CreditCardAccountRepo {
    void saveAccount(Account account);
    void updateAccount(Account account);
    Account loadAccount(String accountNumber);
    Collection<Account> getAccounts();

}
