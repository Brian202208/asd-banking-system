package com.company.banking.strategy;

import com.company.banking.AccountStrategyType;

public class SavingsStrategy implements InterestStrategy {
	@Override
	public double calculateInterest(double balance) {
		if (balance < 1000) return balance * .01;
		else if (balance >= 1000 && balance < 5000) return balance * .02;
		else return balance * .04;
	}

	@Override
	public AccountStrategyType getStrategy() {
		return AccountStrategyType.SAVINGS;
	}
}
