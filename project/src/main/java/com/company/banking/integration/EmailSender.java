package com.company.banking.integration;

import com.company.banking.domain.bankaccount.CompanyAccount;
import com.company.banking.domain.bankaccount.PersonalAccount;
import com.company.banking.domain.Account;
import com.company.banking.domain.AccountEntry;
import com.company.banking.observer.Observer;

public class EmailSender implements Observer {
    //action: send email transaction gt 400$ or negative
    @Override
    public void update(PersonalAccount account, AccountEntry accountEntry) {
        if (accountEntry.getAmount() > 400 || accountEntry.getAmount() < 0 || account.getBalance() + accountEntry.getAmount() < 0)
            sendEmail(account, accountEntry);
    }

    //action: send email company account
    @Override
    public void update(CompanyAccount account, AccountEntry accountEntry) {
        sendEmail(account, accountEntry);
    }

    private void sendEmail(Account account, AccountEntry accountEntry) {
        StringBuilder sb = new StringBuilder();
        sb.append("Dear " + account.getCustomer().getName());
        sb.append("\n");

        if (accountEntry.getAmount() > 0)
            sb.append("There is a " + accountEntry.getDescription() + " " + accountEntry.getAmount() + " to account (" + accountEntry.getDescription() + ")");

        if (accountEntry.getAmount() < 0)
            sb.append("There is a " + accountEntry.getDescription() + " " + accountEntry.getAmount() + " from account (" + accountEntry.getDescription() + ")");
        sb.append("\n");
        sb.append("Account balance now is " + account.getBalance());
        sb.append("\n");
        sb.append("Thank you");
        sb.append("\n");
        sb.append("ASD Bank");

        System.out.println(sb.toString());
    }
}
