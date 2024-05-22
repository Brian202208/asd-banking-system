package com.company.creditcard.repository;

import com.company.banking.domain.Account;

import java.util.ArrayList;
import java.util.Collection;

public class CreditCardAccountRepoImpl implements CreditCardAccountRepo{
    Collection<Account> creditCardAccountList = new ArrayList<>();

    public void saveAccount(Account account) {
        creditCardAccountList.add(account); // add the new
    }

    public void updateAccount(Account account) {
        Account accountexist = loadAccount(account.getAccountNumber());
        if (accountexist != null) {
            creditCardAccountList.remove(accountexist); // remove the old
            creditCardAccountList.add(account); // add the new
        }

    }

    public Account loadAccount(String accountNumber) {
        for (Account account : creditCardAccountList) {
            if (account.getAccountNumber().equals(accountNumber)) {
                return account;
            }
        }
        return null;
    }

    public Collection<Account> getAccounts() {
        return creditCardAccountList;
    }
}
