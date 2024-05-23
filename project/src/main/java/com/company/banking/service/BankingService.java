package com.company.banking.service;

import com.company.framework.domain.Account;
import com.company.framework.service.AccountService;

import java.util.Collection;

public interface BankingService extends AccountService{

        void transferFunds(String fromAccountNumber, String toAccountNumber, double amount, String description);
        void addInterest();
        void generateAccountReports();
}
