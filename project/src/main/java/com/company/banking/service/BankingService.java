package com.company.banking.service;

import com.company.banking.domain.Account;

import java.util.Collection;

public interface BankingService {
        void createAccount(Account account);
        Account getAccount(String accountNumber);
        Collection<Account> getAllAccounts();
        void deposit (String accountNumber, double amount);
        void withdraw (String accountNumber, double amount);
        void transferFunds(String fromAccountNumber, String toAccountNumber, double amount, String description);
        void addInterest();
        void generateAccountReports();
        String billingReport();
}
