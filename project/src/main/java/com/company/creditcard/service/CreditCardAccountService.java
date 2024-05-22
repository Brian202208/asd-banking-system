package com.company.creditcard.service;

import com.company.banking.domain.Account;

import java.util.Collection;

public interface CreditCardAccountService {
    void createAccount(Account account);
    Account getAccount(String accountNumber);
    Collection<Account> getAllAccounts();
    void deposit (String accountNumber, double amount);
    void charge(String accountNumber, double amount);

    void generateMonthlyBillingReport();

}
