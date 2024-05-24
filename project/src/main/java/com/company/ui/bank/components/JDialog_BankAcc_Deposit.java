package com.company.ui.bank.components;

import com.company.framework.domain.Account;
import com.company.ui.bank.BankFrm;
import com.company.ui.framework.components.JDialog_Transaction;

public class JDialog_BankAcc_Deposit extends JDialog_Transaction {

    public JDialog_BankAcc_Deposit(BankFrm parent, String aname) {
        super(parent, aname, "Deposit Money");
    }

    @Override
    protected void JButtonOK_actionPerformed(java.awt.event.ActionEvent event) {

        dispose();
    }
}