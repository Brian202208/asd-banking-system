package com.company.framework.repository;

import com.company.framework.domain.Account;

import java.util.ArrayList;
import java.util.Collection;

public class AccountRepositoryImpl implements AccountRepository {
    Collection<Account> accountlist = new ArrayList<Account>();

    public void saveAccount(Account account) {
        accountlist.add(account); // add the new
    }

    public void updateAccount(Account account) {
        Account accountexist = loadAccount(account.getAccountNumber());
        if (accountexist != null) {
            accountlist.remove(accountexist); // remove the old
            accountlist.add(account); // add the new
        }

    }

    public Account loadAccount(String accountNumber) {
        for (Account account : accountlist) {
            if (account.getAccountNumber().equals(accountNumber)) {
                return account;
            }
        }
        return null;
    }

    public Collection<Account> getAccounts() {
        return accountlist;
    }

}
