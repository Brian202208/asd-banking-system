package com.company.ui.bank.components;


import com.company.ui.bank.BankFrm;
import com.company.ui.framework.components.JDialog_AddAccount;

import java.awt.event.ActionEvent;

public class JDialog__AddCompAcc extends JDialog_AddAccount {
    public JDialog__AddCompAcc(BankFrm parent) {
        super(parent);
        // Additional initialization specific to JDialog_AddCompAcc
    }

    @Override
    protected void initUnCommonComponents() {
        // Initialize common components specific to JDialog_AddCompAcc
//        JLabel8.setText("Acc Nr");
//        getContentPane().add(JLabel8);
//        getContentPane().add(JTextField_ACNR);
    }

    @Override
    protected void JButtonOK_actionPerformed(ActionEvent event) {
        // Implement OK button action specific to JDialog_AddCompAcc
    }
}
