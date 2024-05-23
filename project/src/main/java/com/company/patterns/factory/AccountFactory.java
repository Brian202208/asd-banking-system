package com.company.patterns.factory;

import com.company.common.Customer;
import com.company.framework.domain.AccountType;
import com.company.framework.domain.Account;

public abstract class AccountFactory {
    public abstract Account createAccount(AccountType type, String acc, Customer customer);
}
