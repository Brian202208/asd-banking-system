package com.company.banking.observer;

import com.company.framework.domain.Account;
import com.company.framework.domain.AccountEntry;

public interface Observer {
    void update(Account account, AccountEntry accountEntry);
}
