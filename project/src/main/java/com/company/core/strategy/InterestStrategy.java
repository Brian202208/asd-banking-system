package com.company.core.strategy;

import com.company.core.AccountStrategyType;

public interface InterestStrategy {
    public double calculateInterest(double balance);
    AccountStrategyType getStrategy();
}

