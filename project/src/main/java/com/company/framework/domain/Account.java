package com.company.framework.domain;

import com.company.banking.domain.Customer;
import com.company.banking.observer.Observer;
import com.company.banking.observer.Subject;
import com.company.common.AccountType;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public abstract class Account implements Subject {
    private Customer customer;
    private String accountNumber;
    private List<AccountEntry> entryList = new ArrayList<>();
    private AccountType type;
    private List<Observer> observers = new ArrayList<>();

    public Account(String accountNumber, AccountType type) {
        this.accountNumber = accountNumber;
        this.type = type;
    }
    public abstract AccountType getAccountType();
    public abstract void addInterest();
    @Override
    public abstract void notifyObserver(AccountEntry accountEntry);
    @Override
    public void registerObserver(Observer observer) {
        observers.add(observer);
    }
    @Override
    public void removeObserver(Observer observer) {
        observers.remove(observer);
    }

    public double getBalance() {
        double balance = 0;
        for (AccountEntry entry : entryList) {
            balance += entry.getAmount();
        }
        return balance;
    }

    public void deposit(double amount) {
        AccountEntry entry = new AccountEntry(amount, "deposit", getAccountNumber(), "");
        entryList.add(entry);
        notifyObserver(entry);
    }

    public void withdraw(double amount, String description) {
        AccountEntry entry = new AccountEntry(-amount, description, getAccountNumber(), "");
        entryList.add(entry);
        notifyObserver(entry);
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
}
