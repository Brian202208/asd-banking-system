package com.company.banking.domain;

import com.company.banking.observer.Observer;
import com.company.banking.observer.Subject;
import com.company.banking.strategy.BankingStrategy;
import com.company.base.Strategy;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public abstract class Account implements Subject {
    private Customer customer;
    private String accountNumber;
    private List<AccountEntry> entryList = new ArrayList<AccountEntry>();
    private AccountType type;
    private List<Observer> observers = new ArrayList<>();

    public Account(String accountNumber, AccountType type) {
        this.accountNumber = accountNumber;
        this.type = type;
    }

    public abstract AccountType getAccountType();


    @Override
    public void registerObserver(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void removeObserver(Observer observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObserver(AccountEntry accountEntry) {
    }

    public double getBalance() {
        double balance = 0;
        for (AccountEntry entry : entryList) {
            balance += entry.getAmount();
        }
        return balance;
    }

    public void deposit(double amount) {
        AccountEntry entry = new AccountEntry(amount, "deposit", "", "");
        entryList.add(entry);
    }

    public void withdraw(double amount, String description) {
        AccountEntry entry = new AccountEntry(-amount, description, "", "");
        entryList.add(entry);
    }

    private void addEntry(AccountEntry entry) {
        entryList.add(entry);
    }

    public void transferFunds(Account toAccount, double amount, String description) {
        AccountEntry fromEntry = new AccountEntry(-amount, description, toAccount.getAccountNumber(),
                toAccount.getCustomer().getName());
        AccountEntry toEntry = new AccountEntry(amount, description, toAccount.getAccountNumber(),
                toAccount.getCustomer().getName());

        entryList.add(fromEntry);

        toAccount.addEntry(toEntry);
    }
    public abstract void addInterest();
}
