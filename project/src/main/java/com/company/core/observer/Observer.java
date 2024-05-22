package com.company.core.observer;

import com.company.core.bankaccount.CompanyAccount;
import com.company.core.bankaccount.PersonalAccount;
import com.company.core.domain.AccountEntry;

public interface Observer {
    void update(CompanyAccount account, AccountEntry accountEntry);
    void update(PersonalAccount account, AccountEntry accountEntry);
}
