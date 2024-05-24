package com.company.framework.domain;

import com.company.common.Customer;
import com.company.patterns.observer.Observer;
import com.company.patterns.observer.Subject;
import lombok.Data;

import java.io.Serial;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Data
public abstract class Account implements Subject , Serializable {
    @Serial
    private static final long serialVersionUID = -9128140346995162779L;

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
