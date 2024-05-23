package com.company.framework.factory;

import com.company.banking.domain.Customer;
import com.company.banking.domain.bankaccount.BankAccount;
import com.company.banking.domain.bankaccount.CompanyAccount;
import com.company.banking.domain.bankaccount.PersonalAccount;
import com.company.common.AccountType;

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
