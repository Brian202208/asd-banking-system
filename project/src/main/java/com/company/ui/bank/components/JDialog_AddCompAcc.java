package com.company.ui.bank.components;

import com.company.banking.domain.BankAccount;
import com.company.banking.strategy.CheckingAccountStrategy;
import com.company.banking.strategy.SavingsAccountStrategy;
import com.company.common.Address;
import com.company.common.Customer;
import com.company.framework.domain.Account;
import com.company.framework.domain.AccountType;
import com.company.patterns.factory.BankingAccountFactory;
import com.company.ui.bank.BankFrm;
import com.company.ui.framework.components.JDialog_AddAccount;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.Objects;

public class JDialog_AddCompAcc extends JDialog_AddAccount {
    JTextField JTextField_NoOfEmp;
    JTextField JTextField_EM;

    public JDialog_AddCompAcc(BankFrm parent) {
        super(parent);
        // Additional initialization specific to JDialog_AddCompAcc
        accountFactory = new BankingAccountFactory();
        setTitle("Add company account");
        setModal(true);

        JTextField_NoOfEmp = new JTextField();
        JTextField_EM = new JTextField();
        getContentPane().add(JTextField_NoOfEmp);
        JTextField_NoOfEmp.setBounds(120,216,156,20);
        getContentPane().add(JTextField_EM);
        JTextField_EM.setBounds(120,240,156,20);
    }

    @Override
    protected void initCommonComponents() {
        // Initialize common components specific to JDialog_AddCompAcc
        //RADIO BUTTONS-------->

        JRadioButton_Chk.setText("Checkings");
        JRadioButton_Chk.setActionCommand("Checkings");
        getContentPane().add(JRadioButton_Chk);
        JRadioButton_Chk.setBounds(36,12,84,24);
        JRadioButton_Sav.setText("Savings");
        JRadioButton_Sav.setActionCommand("Savings");
        getContentPane().add(JRadioButton_Sav);
        JRadioButton_Sav.setBounds(36,36,84,24);

        //------------------------->

        //Labels----------->
        JLabel1.setText("Name");
        getContentPane().add(JLabel1);
        JLabel1.setForeground(Color.black);
        JLabel1.setBounds(12,96,48,24);
        JLabel2.setText("Street");
        getContentPane().add(JLabel2);
        JLabel2.setForeground(Color.black);
        JLabel2.setBounds(12,120,48,24);
        JLabel3.setText("City");
        getContentPane().add(JLabel3);
        JLabel3.setForeground(Color.black);
        JLabel3.setBounds(12,144,48,24);
        JLabel4.setText("State");
        getContentPane().add(JLabel4);
        JLabel4.setForeground(Color.black);
        JLabel4.setBounds(12,168,48,24);
        JLabel5.setText("Zip");
        getContentPane().add(JLabel5);
        JLabel5.setForeground(Color.black);
        JLabel5.setBounds(12,192,48,24);

        JLabel6.setText("No of employees");
        getContentPane().add(JLabel6);
        JLabel6.setForeground(Color.black);

        JLabel6.setBounds(12,216,96,24);
        JLabel7.setText("Email");
        getContentPane().add(JLabel7);
        JLabel7.setForeground(Color.black);
        JLabel7.setBounds(12,240,48,24);

        //-- Labels--->

        //TextFields----------->
        getContentPane().add(JTextField_NAME);
        JTextField_NAME.setBounds(120,96,156,20);
        getContentPane().add(JTextField_CT);
        JTextField_CT.setBounds(120,144,156,20);
        getContentPane().add(JTextField_ST);
        JTextField_ST.setBounds(120,168,156,20);
        getContentPane().add(JTextField_STR);
        JTextField_STR.setBounds(120,120,156,20);
        getContentPane().add(JTextField_ZIP);
        JTextField_ZIP.setBounds(120,192,156,20);

        //Buttons
        JButton_OK.setText("OK");
        JButton_OK.setActionCommand("OK");
        getContentPane().add(JButton_OK);
        JButton_OK.setBounds(48,276,84,24);
        JButton_Cancel.setText("Cancel");
        JButton_Cancel.setActionCommand("Cancel");
        getContentPane().add(JButton_Cancel);
        JButton_Cancel.setBounds(156,276,84,24);

        //Account text label and field--------->
        JLabel8.setText("Acc Nr");
        getContentPane().add(JLabel8);
        JLabel8.setForeground(Color.black);
        JLabel8.setBounds(12,72,48,24);
        getContentPane().add(JTextField_ACNR);
        JTextField_ACNR.setBounds(120,72,156,20);
        //------------------>
    }

    @Override
    protected void JButtonOK_actionPerformed(ActionEvent event) {
        // Implement OK button action specific to JDialog_AddCompAcc
        addEntryInTable(createNewAccout());
        dispose();
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

        BankAccount account = (BankAccount) accountFactory.createAccount(AccountType.COMPANY, accountNumber, customer);
        if(JRadioButton_Chk.isSelected()){
            account.setStrategy(new CheckingAccountStrategy());
        } else {
            account.setStrategy(new SavingsAccountStrategy());
        }
        BankFrm bankfrm = (BankFrm) parentframe;
        bankfrm.getBankService().createAccount(account);
        return account;
    }

    private Address createNewAddress(){
        return new Address(JTextField_STR.getText(),JTextField_ST.getText(),JTextField_CT.getText(), JTextField_ZIP.getText());
    }
}
