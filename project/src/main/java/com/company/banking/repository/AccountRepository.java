package com.company.banking.repository;

import com.company.banking.domain.Account;

import java.util.Collection;

public interface AccountRepository {
    void saveAccount(Account account);
    void updateAccount(Account account);
    Account loadAccount(String accountnumber);
    Collection<Account> getAccounts();
}
