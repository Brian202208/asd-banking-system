package com.company.patterns.factory;

import com.company.common.Customer;
import com.company.framework.domain.AccountType;
import com.company.creditcard.domain.CreditCardAccount;
import com.company.framework.domain.Account;

public class CreditCardAccountFactory extends AccountFactory{
    @Override
    public CreditCardAccount createAccount(AccountType type, String acc, Customer customer) {
        CreditCardAccount creditCardAccount =  new CreditCardAccount(acc);
        creditCardAccount.setCustomer(customer);
        return creditCardAccount;
    }
}
