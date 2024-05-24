package com.company.ui.bank.components;

import com.company.ui.bank.BankFrm;
import com.company.ui.framework.components.JDialog_AddAccount;

import java.awt.event.ActionEvent;

public class JDialog__AddPAcc extends JDialog_AddAccount {
    public JDialog__AddPAcc(BankFrm parent) {
        super(parent);
        // Additional initialization specific to JDialog_AddPAcc
    }

    @Override
    protected void initUnCommonComponents() {

    }


    @Override
    protected void JButtonOK_actionPerformed(ActionEvent event) {
        // Implement OK button action specific to JDialog_AddPAcc
    }
}