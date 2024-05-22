package com.company.core.bankaccount.strategy;


import com.company.core.AccountStrategyType;

public class CheckingsStrategy implements InterestStrategy {
	@Override
	public double calculateInterest(double balance) {
		if (balance < 1000) return balance * .015;
		else return balance * .025;
	}

	@Override
	public AccountStrategyType getStrategy() {
		return null;
	}
}
