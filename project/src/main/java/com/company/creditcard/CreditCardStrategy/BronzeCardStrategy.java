package com.company.creditcard.CreditCardStrategy;

public class BronzeCardStrategy implements CreditCardStrategy {


    @Override
    public double monthlyInterest() {
        return .1;
    }

    @Override
    public double minimumPayment() {
        return .14;
    }
}
