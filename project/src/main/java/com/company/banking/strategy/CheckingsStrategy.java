package com.company.banking.strategy;


import com.company.banking.AccountStrategyType;

public class CheckingsStrategy implements InterestStrategy {
	@Override
	public double calculateInterest(double balance) {
		if (balance < 1000) return balance * .015;
		else return balance * .025;
	}

	@Override
	public AccountStrategyType getStrategy() {
		return AccountStrategyType.CHECKING;
	}
}
