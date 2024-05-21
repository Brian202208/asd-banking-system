package com.company.core.bankaccount;

import com.company.core.bankaccount.strategy.InterestStrategy;
import com.company.core.AccountStrategyType;
import com.company.core.domain.Account;
import com.company.core.domain.AccountEntry;
import com.company.core.domain.AccountType;
import com.company.core.domain.Customer;

public abstract class BankAccount extends Account {
    InterestStrategy interestStrategy;

    public BankAccount(String accountNumber, AccountType type) {
        super(accountNumber, type);
    }

    public AccountStrategyType getAccountStrategy() {
        return this.interestStrategy.getStrategy();
    }

    public void setInterestStrategy(InterestStrategy interestStrategy) {
        this.interestStrategy = interestStrategy;
    }

//    public String generateReport(BankAccount bankAccount, String str) {
//
//        StringBuilder sb = new StringBuilder();
//        String header = "-Date          " + "               -Description       " + "              -Amount         \n";
//        Customer reportcustomer = bankAccount.getCustomer();
//        sb.append("AccountHolder Name ++: " + reportcustomer.getName() + "\n");
//        sb.append("AccountNumber Number : " + bankAccount.getAccountNumber() + "\n");
//        sb.append("=========================================================\n");
//        sb.append(header);
//        sb.append("=========================================================\n");
//        for (AccountEntry entry : bankAccount.getEntryList()) {
//            String body = entry.getDate().toString()
//                    + "      "
//                    + entry.getDescription()
//                    + "      "
//                    + entry.getAmount()
//                    + "    \n";
//            sb.append(body);
//        }
//        sb.append("=========================================================\n");
//        sb.append("               Current Balance:" + bankAccount.getBalance());
//        sb.append("\n\n");
//        str += sb.toString();
//        return str;
//    }
}
