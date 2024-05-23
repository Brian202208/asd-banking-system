package com.company.banking.observer;

import com.company.framework.domain.AccountEntry;

public interface Subject {
    void registerObserver(Observer observer);
    void removeObserver(Observer observer);
    void notifyObserver(AccountEntry accountEntry);
}
