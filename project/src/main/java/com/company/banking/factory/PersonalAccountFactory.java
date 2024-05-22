package com.company.banking.factory;

import com.company.banking.domain.bankaccount.PersonalAccount;
import com.company.banking.domain.Account;
import com.company.banking.domain.Address;
import com.company.banking.domain.Customer;
import com.company.banking.strategy.CheckingsStrategy;
import com.company.banking.strategy.InterestStrategy;
import com.company.banking.strategy.SavingsStrategy;

public class PersonalAccountFactory extends FactoryAccount {
    //TODO: it's a demo code to create personal account factory which need to change acccordingly
    @Override
    public Account getAccount(String row1, String row2, String row3, String row4, String row5, String row6, String row7, String row8, String row9) {
        Customer customer = new Customer(row1);
        Address address = new Address(row2, row4, row3, row5);
        customer.setAddress(address);
        customer.setEmail(row8);
        customer.setBirthdate(row7);

        PersonalAccount account = new PersonalAccount(row6);
        account.setCustomer(customer);
        //account.setInterestStrategy(createStrategy(row9));
        return  account;
    }

    private InterestStrategy createStrategy(String strategy) {

        switch (strategy) {
            case "Savings":
                return new SavingsStrategy();
            case "Checkings":
                return new CheckingsStrategy();
        }
        return null;
    }
}
