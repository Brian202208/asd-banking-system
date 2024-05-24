package com.company.ui.ccard.components;

import com.company.ui.bank.BankFrm;
import com.company.ui.ccard.CardFrm;
import com.company.ui.framework.BaseUIFrame;
import com.company.ui.framework.components.JDialog_Transaction;

public class JDialog_CCAcc_Charge extends JDialog_Transaction {

    public JDialog_CCAcc_Charge(BaseUIFrame parent, String aname) {
        super(parent, aname, "Charge Account");
    }

    @Override
    protected void JButtonOK_actionPerformed(java.awt.event.ActionEvent event) {

        dispose();
    }
}

