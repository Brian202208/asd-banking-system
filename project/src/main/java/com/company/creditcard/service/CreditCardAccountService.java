package com.company.creditcard.service;

import com.company.framework.domain.Account;
import com.company.framework.service.AccountService;

import java.util.Collection;

public interface CreditCardAccountService extends AccountService{

    void charge(String accountNumber, double amount);
    void generateMonthlyBillingReport();
}
