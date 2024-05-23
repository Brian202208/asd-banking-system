package com.company.creditcard.service;

import com.company.framework.domain.Account;
import com.company.common.AccountType;
import com.company.creditcard.domain.CreditCardAccount;
import com.company.framework.service.AccountServiceImpl;


public class CreditCardAccountServiceImpl extends AccountServiceImpl implements CreditCardAccountService {

    private static CreditCardAccountServiceImpl instance = null;
    private CreditCardAccountServiceImpl() {}
    public static CreditCardAccountServiceImpl getInstance() {
        if (instance == null) {
            instance = new CreditCardAccountServiceImpl();
        }
        return instance;
    }

    //Same as withdraw
    @Override
    public void charge(String accountNumber, double amount) {
        withdraw(accountNumber,amount,"charge");
    }

    @Override
    public String generateMonthlyBillingReport() {
        StringBuilder s = new StringBuilder();
        for (Account account : getAllAccounts()) {
            if (account.getAccountType() == AccountType.CREDIT){
                s.append(((CreditCardAccount) account).billingReport()).append("/n");
                System.out.println(((CreditCardAccount) account).billingReport());
            }
        }
        return s.toString();
    }

    public Account getAccountByName(String name) {
        for (Account account : getAllAccounts()) {
            if (account.getCustomer().getName().equals(name)){
                return account;
            }
        }
        return null;
    }
}
