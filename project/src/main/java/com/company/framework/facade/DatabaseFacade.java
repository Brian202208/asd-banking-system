package com.company.framework.facade;

import com.company.framework.domain.Account;

import java.util.Collection;
import java.util.List;

public interface DatabaseFacade {
    void saveAccountToDatabase(Account account);
    void updateAccountToDatabase(Account account);
    Account loadAccountFromDatabase(String accountNumber);
    List<Account> getAccountsFromDatabase();
}
