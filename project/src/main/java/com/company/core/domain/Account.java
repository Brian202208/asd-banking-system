package com.company.core.domain;

import com.company.core.AccountStrategyType;
import com.company.core.observer.Observer;
import com.company.core.observer.Subject;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class Account implements Subject {
    private Customer customer;
    private String accountNumber;
    private List<AccountEntry> entryList = new ArrayList<AccountEntry>();
    private AccountType type;
    private List<Observer> observers = new ArrayList<>();

    public Account(String accountNumber, AccountType type) {
        this.accountNumber = accountNumber;
        this.type = type;
    }

    //by default value
    public AccountStrategyType getAccountStrategy() {
        return AccountStrategyType.CHECKING;
    }
    public AccountType getAccountType() {
        return AccountType.PERSONAL;
    };

    public String getAccountNumber() {
        return accountNumber;
    }

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

    public List<Observer> getObservers() {
        return observers;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
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

    public void withdraw(double amount) {
        AccountEntry entry = new AccountEntry(-amount, "withdraw", "", "");
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

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Collection<AccountEntry> getEntryList() {
        return entryList;
    }
}
