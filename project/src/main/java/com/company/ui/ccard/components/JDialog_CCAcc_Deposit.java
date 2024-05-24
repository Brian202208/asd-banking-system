package com.company.ui.ccard.components;

import com.company.ui.bank.BankFrm;
import com.company.ui.ccard.CardFrm;
import com.company.ui.framework.components.JDialog_Transaction;

public class JDialog_CCAcc_Deposit extends JDialog_Transaction {

    public JDialog_CCAcc_Deposit(CardFrm parent, String aname) {
        super(parent, aname, "Pay Bills");
    }

    @Override
    protected void JButtonOK_actionPerformed(java.awt.event.ActionEvent event) {

        dispose();
    }
}