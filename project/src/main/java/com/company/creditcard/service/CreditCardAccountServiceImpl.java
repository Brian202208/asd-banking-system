package com.company.creditcard.service;

import com.company.framework.domain.Account;
import com.company.common.AccountType;
import com.company.creditcard.domain.CreditCardAccount;
import com.company.framework.service.AccountServiceImpl;


public class CreditCardAccountServiceImpl extends AccountServiceImpl implements CreditCardAccountService {

    //Same as withdraw
    @Override
    public void charge(String accountNumber, double amount) {
        withdraw(accountNumber,amount,"charge");
    }

    @Override
    public void generateMonthlyBillingReport() {
        for (Account account : getAllAccounts()) {
            if (account.getAccountType() == AccountType.CREDIT){
                System.out.println(((CreditCardAccount) account).billingReport());
            }
        }
    }
}
