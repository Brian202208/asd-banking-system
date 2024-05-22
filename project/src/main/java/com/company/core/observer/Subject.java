package com.company.core.observer;

import com.company.core.domain.AccountEntry;

public interface Subject {
    void registerObserver(Observer observer);
    void removeObserver(Observer observer);
    void notifyObserver(AccountEntry accountEntry);
}
