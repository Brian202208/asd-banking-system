package com.company.banking.observer;

import com.company.banking.domain.Account;
import com.company.banking.domain.bankaccount.CompanyAccount;
import com.company.banking.domain.bankaccount.PersonalAccount;
import com.company.banking.domain.AccountEntry;

public interface Observer {
    void update(Account account, AccountEntry accountEntry);
}
