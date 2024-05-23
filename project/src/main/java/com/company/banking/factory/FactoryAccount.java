package com.company.banking.factory;

import com.company.framework.domain.Account;

public abstract class FactoryAccount {
    public abstract Account getAccount(String row1, String row2, String row3, String row4,
                                       String row5, String row6, String row7, String row8, String row9);

    //following the template pattern
    //TODO: arguments in the method may need to modified. createAccount method should be invoked
    //from Dialog frame of companyaccount/personal account so that factory can create
    public Account createAccount(String row1, String row2, String row3, String row4,
                                 String row5, String row6, String row7, String row8, String row9) {
        return getAccount(row1, row2, row3, row4,
                row5, row6, row7, row8, row9);

    }
}
