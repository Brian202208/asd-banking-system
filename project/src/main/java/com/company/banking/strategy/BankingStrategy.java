package com.company.banking.strategy;

import com.company.base.Strategy;

public interface BankingStrategy extends Strategy {
    public double calculateInterest(double balance);
}

