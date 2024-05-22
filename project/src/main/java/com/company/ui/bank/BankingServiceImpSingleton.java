package com.company.ui.bank;

import com.company.banking.service.BankingServiceImpl;

public class BankingServiceImpSingleton {
    private static BankingServiceImpl instance = null;

    private BankingServiceImpSingleton() {
    }

    public static BankingServiceImpl getInstance() {
        if (instance == null) {
            instance = new BankingServiceImpl();
        }
        return instance;
    }
}
