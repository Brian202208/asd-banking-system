package com.company.framework.service;

import com.company.banking.integration.EmailSender;
import com.company.framework.repository.AccountRepository;
import com.company.framework.repository.AccountRepositoryImpl;
import com.company.framework.domain.Account;

import java.util.Collection;

public class AccountServiceImpl implements AccountService{
    public AccountRepository accountRepository;

    public AccountServiceImpl(){
        accountRepository = new AccountRepositoryImpl();
    }
    @Override
    public void createAccount(Account account) {
        accountRepository.saveAccount(account);
        account.registerObserver(new EmailSender());
    }

    @Override
    public Account getAccount(String accountNumber) {
        return accountRepository.loadAccount(accountNumber);
    }

    @Override
    public Collection<Account> getAllAccounts() {
        return accountRepository.getAccounts();

    }

    @Override
    public void deposit(String accountNumber, double amount) {
        Account account = accountRepository.loadAccount(accountNumber);
        account.deposit(amount);
        accountRepository.updateAccount(account);
    }

    @Override
    public void withdraw(String accountNumber, double amount, String description) {
        Account account = accountRepository.loadAccount(accountNumber);
        account.withdraw(amount,description);
        accountRepository.updateAccount(account);
    }
}
