package com.company.framework.factory;

import com.company.banking.domain.Customer;
import com.company.common.AccountType;
import com.company.creditcard.domain.CreditCardAccount;
import com.company.framework.domain.Account;

public class CreditCardAccountFactory extends AccountFactory{
    @Override
    public Account createAccount(AccountType type, String acc, Customer customer) {
        CreditCardAccount creditCardAccount =  new CreditCardAccount(acc);
        creditCardAccount.setCustomer(customer);
        return creditCardAccount;
    }
}
