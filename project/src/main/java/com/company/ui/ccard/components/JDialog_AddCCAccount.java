package com.company.ui.ccard.components;

import com.company.ui.ccard.CardFrm;
import com.company.ui.framework.components.JDialog_AddAccount;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.MouseEvent;

public class JDialog_AddCCAccount extends JDialog_AddAccount {
    public JDialog_AddCCAccount(CardFrm parent) {
        super(parent);
        // Additional initialization specific to JDialog_AddCCAccount
    }

    @Override
    protected void initCommonComponents() {
        // Initialize common components specific to JDialog_AddCCAccount
        JRadioButton_Extra = new JRadioButton(); // Additional radio button
        getContentPane().add(JRadioButton_Extra);
        JLabel8.setText("CC number");
        getContentPane().add(JLabel8);
        getContentPane().add(JTextField_ACNR);
    }

    @Override
    protected void JButtonOK_actionPerformed(ActionEvent event) {
        // Implement OK button action specific to JDialog_AddCCAccount
    }

    @Override
    protected void JRadioButtonExtra_mouseClicked(MouseEvent event) {
        // Handle extra radio button click specific to JDialog_AddCCAccount
    }
}
