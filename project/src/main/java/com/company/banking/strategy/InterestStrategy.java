package com.company.banking.strategy;

import com.company.banking.AccountStrategyType;

public interface InterestStrategy {
    public double calculateInterest(double balance);
    AccountStrategyType getStrategy();
}

