package com.company.creditcard.service;

import com.company.banking.domain.Account;
import com.company.banking.integration.EmailSender;
import com.company.common.AccountType;
import com.company.creditcard.domain.CreditCardAccount;
import com.company.creditcard.repository.CreditCardAccountRepo;
import com.company.creditcard.repository.CreditCardAccountRepoImpl;

import java.util.Collection;

public class CreditCardAccountServiceImpl implements CreditCardAccountService {
    private final CreditCardAccountRepo creditCardAccountRepo;

    public CreditCardAccountServiceImpl() {
        this.creditCardAccountRepo = new CreditCardAccountRepoImpl();
    }

    @Override
    public void createAccount(Account account) {
        creditCardAccountRepo.saveAccount(account);
        account.registerObserver(new EmailSender());
    }

    @Override
    public Account getAccount(String accountNumber) {
        return creditCardAccountRepo.loadAccount(accountNumber);
    }

    @Override
    public Collection<Account> getAllAccounts() {
        return creditCardAccountRepo.getAccounts();
    }

    @Override
    public void deposit(String accountNumber, double amount) {
        Account account = creditCardAccountRepo.loadAccount(accountNumber);
        account.deposit(amount);
        creditCardAccountRepo.updateAccount(account);
    }

    //Same as withdraw
    @Override
    public void charge(String accountNumber, double amount) {
        Account account = creditCardAccountRepo.loadAccount(accountNumber);
        account.withdraw(amount, "Charge");
        creditCardAccountRepo.updateAccount(account);
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
