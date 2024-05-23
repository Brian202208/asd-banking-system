package com.company.framework.factory;

import com.company.banking.domain.Customer;
import com.company.banking.domain.bankaccount.CompanyAccount;
import com.company.banking.domain.bankaccount.PersonalAccount;
import com.company.common.AccountType;
import com.company.creditcard.domain.CreditCardAccount;
import com.company.framework.domain.Account;

public abstract class AccountFactory {
    public abstract Account createAccount(AccountType type, String acc, Customer customer);
}
