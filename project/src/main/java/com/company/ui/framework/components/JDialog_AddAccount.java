package com.company.ui.framework.components;


import com.company.banking.service.BankingService;
import com.company.banking.service.BankingServiceImpl;
import com.company.patterns.factory.BankingAccountFactory;
import com.company.ui.bank.BankFrm;

import javax.swing.*;
import java.awt.*;

public abstract class JDialog_AddAccount extends JDialog {
    protected BankFrm parentframe;
    protected BankingService bankingService;
    protected BankingAccountFactory accountFactory;

    protected JRadioButton JRadioButton_Chk;
    protected JRadioButton JRadioButton_Sav;
    protected JRadioButton JRadioButton_Extra; // Additional radio button specific to JDialog_AddCCAccount
    protected JLabel JLabel0;
    protected JLabel JLabel1;
    protected JLabel JLabel2;
    protected JLabel JLabel3;
    protected JLabel JLabel4;
    protected JLabel JLabel5;
    protected JLabel JLabel6;
    protected JLabel JLabel7;
    protected JTextField JTextField_ACNR;
    protected JTextField JTextField_NAME;
    protected JTextField JTextField_CT;
    protected JTextField JTextField_ST;
    protected JTextField JTextField_STR;
    protected JTextField JTextField_ZIP;
    protected JButton JButton_OK;
    protected JButton JButton_Cancel;

    public JDialog_AddAccount(BankFrm parent) {
        super(parent);
        parentframe = parent;
        bankingService = BankingServiceImpl.getInstance();
        accountFactory = new BankingAccountFactory();

        // Initialize common components
        JRadioButton_Chk = new JRadioButton();
        JRadioButton_Sav = new JRadioButton();

        //---- Label ------>



        JLabel1 = new JLabel("name");
        jLabelConfig(JLabel1, 84,48,24);

        JLabel2 = new JLabel("Street");
        jLabelConfig(JLabel2, 108,48,24);

        JLabel3 = new JLabel("City");

        jLabelConfig(JLabel3, 132,48,24);

        JLabel4 = new JLabel("State");

        jLabelConfig(JLabel4, 156,48,24);

        JLabel5 = new JLabel("Zip");

        jLabelConfig(JLabel5, 180,48,24);

        JLabel6 = new JLabel("Birth Date");

        jLabelConfig(JLabel6, 204,96,24);

        JLabel7 = new JLabel("Email");

        jLabelConfig(JLabel7, 228,48,24);

//        JLabel0 = new JLabel("Acc nr");
//        jLabelConfig(JLabel0, 72,48,24);
        //---- Label ------/

        //--- J textField ---->

//        JTextField_ACNR = new JTextField();
//        jTextFieldConfig(JTextField_ACNR,60);

        JTextField_NAME = new JTextField();
        jTextFieldConfig(JTextField_NAME,84);

        JTextField_CT = new JTextField();
        jTextFieldConfig(JTextField_CT,132);

        JTextField_ST = new JTextField();
        jTextFieldConfig(JTextField_ST,156);

        JTextField_STR = new JTextField();
        jTextFieldConfig(JTextField_STR,108);

        JTextField_ZIP = new JTextField();
        jTextFieldConfig(JTextField_ZIP,60);

        JButton_OK = new JButton();
        JButton_Cancel = new JButton();
        JTextField_ACNR = new JTextField();

        // Add common components to content pane
        getContentPane().setLayout(null);

        getContentPane().add(JRadioButton_Chk);
        getContentPane().add(JRadioButton_Sav);
        getContentPane().add(JButton_OK);
        getContentPane().add(JButton_Cancel);
        getContentPane().add(JTextField_ACNR);

        // Register common listeners
        SymMouse aSymMouse = new SymMouse();
        JRadioButton_Chk.addMouseListener(aSymMouse);
        JRadioButton_Sav.addMouseListener(aSymMouse);
        SymAction lSymAction = new SymAction();
        JButton_OK.addActionListener(lSymAction);
        JButton_Cancel.addActionListener(lSymAction);

        // Initialize uncommon components
        initUnCommonComponents();
    }

    protected abstract void initUnCommonComponents();

    // Inner classes for listeners
    class SymMouse extends java.awt.event.MouseAdapter {
        public void mouseClicked(java.awt.event.MouseEvent event) {
            Object object = event.getSource();
            if (object == JRadioButton_Chk) {
                JRadioButtonChk_mouseClicked(event);
            } else if (object == JRadioButton_Sav) {
                JRadioButtonSav_mouseClicked(event);
            } else if (object == JRadioButton_Extra) { // Specific to JDialog_AddCCAccount
                JRadioButtonExtra_mouseClicked(event);
            }
        }
    }

    class SymAction implements java.awt.event.ActionListener {
        public void actionPerformed(java.awt.event.ActionEvent event) {
            Object object = event.getSource();
            if (object == JButton_OK)
                JButtonOK_actionPerformed(event);
            else if (object == JButton_Cancel)
                JButtonCalcel_actionPerformed(event);
        }
    }

    // Common methods
    protected void JRadioButtonChk_mouseClicked(java.awt.event.MouseEvent event) {
        // Implement in subclass if needed
    }

    protected void JRadioButtonSav_mouseClicked(java.awt.event.MouseEvent event) {
        // Implement in subclass if needed
    }

    protected void JRadioButtonExtra_mouseClicked(java.awt.event.MouseEvent event) {
        // Implement in subclass if needed
    }

    protected abstract void JButtonOK_actionPerformed(java.awt.event.ActionEvent event);

    protected void JButtonCalcel_actionPerformed(java.awt.event.ActionEvent event) {
        // Make this frame invisible if Cancel button is clicked
        dispose();
    }

    protected void jLabelConfig(JLabel jLabel, int y, int width, int height){
        jLabel.setForeground(Color.black);
        jLabel.setBounds(12,y,width,height);
        getContentPane().add(jLabel);
    }

    protected void jTextFieldConfig(JTextField jTextField, int y){
        jTextField.setBounds(84,y,156,20);
        getContentPane().add(jTextField);
    }
}
