package com.company.core.factory;

import com.company.core.bankaccount.PersonalAccount;
import com.company.core.domain.Account;
import com.company.core.domain.Address;
import com.company.core.domain.Customer;
import com.company.core.strategy.CheckingsStrategy;
import com.company.core.strategy.InterestStrategy;
import com.company.core.strategy.SavingsStrategy;

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
