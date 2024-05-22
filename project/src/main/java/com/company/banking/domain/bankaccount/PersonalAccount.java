package com.company.banking.domain.bankaccount;

import com.company.banking.AccountStrategyType;
import com.company.banking.domain.AccountEntry;
import com.company.banking.domain.AccountType;
import com.company.banking.observer.Observer;
import lombok.Setter;

public class PersonalAccount extends BankAccount{

    public PersonalAccount(String accountNumber) {
        super(accountNumber, AccountType.PERSONAL);
    }

    @Override
    public AccountType getAccountType() {
        return AccountType.PERSONAL;
    }

    @Override
    public void notifyObserver(AccountEntry entry) {
        for(Observer o: getObservers()){
            o.update( this, entry);
        }
    }
}
