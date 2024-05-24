package com.company.ui.bank.components;

import com.company.ui.bank.BankFrm;
import com.company.ui.framework.components.JDialog_Transaction;

public class JDialog_BankAcc_Withdraw extends JDialog_Transaction {

    public JDialog_BankAcc_Withdraw(BankFrm parent, String aname) {
        super(parent, aname, "Withdraw Money");
    }

    @Override
    protected void JButtonOK_actionPerformed(java.awt.event.ActionEvent event) {

        dispose();
    }
}

