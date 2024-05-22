package com.company.banking.domain.bankaccount;

import com.company.banking.strategy.BankingStrategy;
import com.company.banking.domain.Account;
import com.company.banking.domain.AccountType;
import lombok.Setter;

@Setter
public abstract class BankAccount extends Account {
    BankingStrategy bankingStrategy;

    public BankAccount(String accountNumber, AccountType type) {
        super(accountNumber, type);
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
