package com.company.creditcard;

import com.company.banking.domain.Account;
import com.company.banking.domain.Customer;
import com.company.creditcard.domain.CreditCardAccount;
import com.company.creditcard.service.CreditCardAccountService;
import com.company.creditcard.service.CreditCardAccountServiceImpl;

public class CreditCardDriver {
    public static void main(String[] args) {
        CreditCardAccountService creditCardAccountService = new CreditCardAccountServiceImpl();

        // create 2 accounts;
        Customer customer = new Customer("James");

        Account creditCardAccount = new CreditCardAccount("1263862");
        creditCardAccount.setCustomer(customer);

        creditCardAccountService.createAccount(creditCardAccount);


        // use account 1;
        creditCardAccountService.deposit("1263862", 240);
        creditCardAccountService.deposit("1263862", 529);
        creditCardAccountService.charge("1263862", 230);


        //Generated Account Reports with Interest
        creditCardAccountService.generateMonthlyBillingReport();
    }
}
