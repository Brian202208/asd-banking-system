package com.company.banking.observer;

import com.company.banking.domain.bankaccount.CompanyAccount;
import com.company.banking.domain.bankaccount.PersonalAccount;
import com.company.banking.domain.AccountEntry;

public interface Observer {
    void update(CompanyAccount account, AccountEntry accountEntry);
    void update(PersonalAccount account, AccountEntry accountEntry);
}
