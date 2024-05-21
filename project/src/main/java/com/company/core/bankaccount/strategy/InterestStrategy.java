package com.company.core.bankaccount.strategy;

import com.company.core.AccountStrategyType;

public interface InterestStrategy {
    public double calculateInterest(double balance);
    AccountStrategyType getStrategy();
}

