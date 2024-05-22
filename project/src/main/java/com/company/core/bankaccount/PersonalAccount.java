package com.company.core.bankaccount;

import com.company.core.AccountStrategyType;
import com.company.core.domain.AccountEntry;
import com.company.core.domain.AccountType;
import com.company.core.observer.Observer;

public class PersonalAccount extends BankAccount{

    private AccountStrategyType accountStrategyType;
    public PersonalAccount(String accountNumber) {
        super(accountNumber, AccountType.PERSONAL);
    }

    @Override
    public AccountType getAccountType() {
        return AccountType.PERSONAL;
    }

    public PersonalAccount(String accountNumber, AccountType type) {
        super(accountNumber, type);
    }
    @Override
    public void notifyObserver(AccountEntry entry) {
        for(Observer o: getObservers()){
            o.update( this, entry);
        }
    }
}
