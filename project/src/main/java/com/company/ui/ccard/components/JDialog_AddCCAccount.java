package com.company.ui.ccard.components;

import com.company.common.Address;
import com.company.common.Customer;
import com.company.creditcard.domain.CreditCardAccount;
import com.company.framework.domain.Account;
import com.company.framework.domain.AccountType;
import com.company.patterns.factory.CreditCardAccountFactory;
import com.company.ui.bank.BankFrm;
import com.company.ui.ccard.CardFrm;
import com.company.ui.framework.components.JDialog_AddAccount;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.MouseEvent;
import java.util.Objects;

public class JDialog_AddCCAccount extends JDialog_AddAccount {
    JTextField JTextField_CCNR;
    JTextField JTextField_ExpDate;
    JRadioButton jRadioButtonBronze;

    public JDialog_AddCCAccount(CardFrm parent) {
        super(parent);
        accountFactory = new CreditCardAccountFactory();
        // Additional initialization specific to JDialog_AddCCAccount
        setTitle("Add credit card account");
        setModal(true);

        JTextField_CCNR = new JTextField();
        JTextField_ExpDate = new JTextField();
        jRadioButtonBronze = new JRadioButton(); // Additional radio button


        getContentPane().add(JTextField_CCNR);
        JTextField_CCNR.setBounds(84,252,156,20);
        getContentPane().add(JTextField_ExpDate);
        JTextField_ExpDate.setBounds(84,276,156,20);

        //Radio Button---->

        getContentPane().add(JRadioButton_Extra);
        jRadioButtonBronze.setText("Bronze");
        jRadioButtonBronze.setActionCommand("Savings");
        getContentPane().add(jRadioButtonBronze);
        jRadioButtonBronze.setBounds(36,60,84,24);
    }

    @Override
    protected void initCommonComponents() {
        // Initialize common components specific to JDialog_AddCCAccount

        //JRadioButton_Gold
        JRadioButton_Chk.setText("Gold");
        JRadioButton_Chk.setActionCommand("Checkings");
        getContentPane().add(JRadioButton_Chk);
        JRadioButton_Chk.setBounds(36,12,84,24);
        //-------------->

        //JRadioButton_Silver
        JRadioButton_Sav.setText("Silver");
        JRadioButton_Sav.setActionCommand("Savings");
        getContentPane().add(JRadioButton_Sav);
        JRadioButton_Sav.setBounds(36,36,84,24);
        //-------------->

        //Labels------->
        JLabel1.setText("Name");
        getContentPane().add(JLabel1);
        JLabel1.setForeground(java.awt.Color.black);
        JLabel1.setBounds(12,108,48,24);
        JLabel2.setText("Street");
        getContentPane().add(JLabel2);
        JLabel2.setForeground(java.awt.Color.black);
        JLabel2.setBounds(12,132,48,24);
        JLabel3.setText("City");
        getContentPane().add(JLabel3);
        JLabel3.setForeground(java.awt.Color.black);
        JLabel3.setBounds(12,156,48,24);
        JLabel4.setText("State");
        getContentPane().add(JLabel4);
        JLabel4.setForeground(java.awt.Color.black);
        JLabel4.setBounds(12,180,48,24);
        JLabel5.setText("Zip");
        getContentPane().add(JLabel5);
        JLabel5.setForeground(java.awt.Color.black);
        JLabel5.setBounds(12,204,48,24);
        JLabel6.setText("CC number");
        getContentPane().add(JLabel6);
        JLabel6.setForeground(java.awt.Color.black);
        JLabel6.setBounds(12,252,96,24);
        JLabel7.setText("Exp. Date");
        getContentPane().add(JLabel7);
        JLabel7.setForeground(java.awt.Color.black);
        JLabel7.setBounds(12,276,72,24);


        //Jtext fields ------->
        getContentPane().add(JTextField_NAME);
        JTextField_NAME.setBounds(84,108,156,20);
        getContentPane().add(JTextField_CT);
        JTextField_CT.setBounds(84,156,156,20);
        getContentPane().add(JTextField_ST);
        JTextField_ST.setBounds(84,180,156,20);
        getContentPane().add(JTextField_STR);
        JTextField_STR.setBounds(84,132,156,20);
        getContentPane().add(JTextField_ZIP);
        JTextField_ZIP.setBounds(84,204,156,20);


        //Button----------->
        JButton_OK.setText("OK");
        JButton_OK.setActionCommand("OK");
        getContentPane().add(JButton_OK);
        JButton_OK.setBounds(48,312,84,24);
        JButton_Cancel.setText("Cancel");
        JButton_Cancel.setActionCommand("Cancel");
        getContentPane().add(JButton_Cancel);
        //-------->




        JLabel8.setText("CC number");
        getContentPane().add(JLabel8);
        getContentPane().add(JTextField_ACNR);
    }

    @Override
    protected void JButtonOK_actionPerformed(ActionEvent event) {
        // Implement OK button action specific to JDialog_AddCCAccount
        addEntryInTable(createNewAccout());
        dispose();
    }

    @Override
    protected void JRadioButtonExtra_mouseClicked(MouseEvent event) {
        // Handle extra radio button click specific to JDialog_AddCCAccount
    }

    private void addEntryInTable(Account account) {
        System.out.println("rowcount " + parentframe.getModel().getRowCount());

        parentframe.getRowData()[0] = account.getAccountNumber();
        parentframe.getRowData()[1] = account.getCustomer().getName();
        parentframe.getRowData()[2] = account.getCustomer().getAddress().getCity();
        parentframe.getRowData()[3] = account.getAccountType() == AccountType.COMPANY ? "C": "P";
        parentframe.getRowData()[4] = JRadioButton_Chk.isSelected()? "Ch": "S";
        parentframe.getRowData()[5] = String.valueOf(Objects.isNull(account.getBalance()) ? "0": account.getBalance());

        parentframe.getModel().addRow(parentframe.getRowData());
    }

    private Account createNewAccout() {
        Customer customer = new Customer(JTextField_NAME.getText());
        customer.setAddress(createNewAddress());
        String accountNumber = JTextField_ACNR.getText();

        CreditCardAccount account = (CreditCardAccount) accountFactory.createAccount(AccountType.COMPANY, accountNumber, customer);

//        if(JRadioButton_Chk.isSelected()){
//            account.setStrategy(new CheckingAccountStrategy());
//        } else {
//            account.setStrategy(new SavingsAccountStrategy());
//        }
        BankFrm bankfrm = (BankFrm) parentframe;
        bankfrm.getBankService().createAccount(account);
        return account;
    }

    private Address createNewAddress(){
        return new Address(JTextField_STR.getText(),JTextField_ST.getText(),JTextField_CT.getText(), JTextField_ZIP.getText());
    }
}
