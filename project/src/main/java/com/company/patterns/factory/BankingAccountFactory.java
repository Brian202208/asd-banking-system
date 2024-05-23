package com.company.patterns.factory;

import com.company.common.Customer;
import com.company.banking.domain.BankAccount;
import com.company.banking.domain.CompanyAccount;
import com.company.banking.domain.PersonalAccount;
import com.company.framework.domain.AccountType;

public class BankingAccountFactory extends AccountFactory{
    @Override
    public BankAccount createAccount(AccountType type, String acc, Customer customer) {
        BankAccount account = null;

        switch (type) {
            case COMPANY:
                account = new CompanyAccount(acc);
                break;
            case PERSONAL:
                account = new PersonalAccount(acc);
                break;
            default:
                break;
        }

        account.setCustomer(customer);
        return account;
    }
}
