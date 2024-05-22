package com.company.banking.strategy;

public interface BankingStrategy extends Strategy {
    public double calculateInterest(double balance);
}

