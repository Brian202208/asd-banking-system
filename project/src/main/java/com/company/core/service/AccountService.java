package com.company.core.service;

import com.company.core.domain.Account;
import com.company.core.domain.AccountType;

import java.util.Collection;

public interface AccountService {
        Account createAccount(String accountNumber, String customerName, AccountType type);
        Account getAccount(String accountNumber);
        Collection<Account> getAllAccounts();
        void deposit (String accountNumber, double amount);
        void withdraw (String accountNumber, double amount);
        void transferFunds(String fromAccountNumber, String toAccountNumber, double amount, String description);
        void addInterest();
        void generateAccountReports();
}