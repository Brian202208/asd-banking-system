package com.company.ui.bank.components;

import com.company.framework.domain.Account;
import com.company.ui.bank.BankFrm;
import com.company.ui.framework.components.JDialog_Transaction;

import java.util.Objects;

public class JDialog_BankAcc_Withdraw extends JDialog_Transaction {

    public JDialog_BankAcc_Withdraw(BankFrm parent, String aname) {
        super(parent, aname, "Withdraw Money");
    }

    @Override
    protected void JButtonOK_actionPerformed(java.awt.event.ActionEvent event) {
        BankFrm bankFrm = (BankFrm) parentframe;
        int selectionIndex = bankFrm.getTable().getSelectionModel().getMinSelectionIndex();
        if(selectionIndex >= 0){
            String accountNumber = (String)bankFrm.getModel().getValueAt(selectionIndex, 0);
            String amount = JTextField_AMT.getText();
            bankFrm.getBankService().withdraw(accountNumber, Double.parseDouble(amount));
            Account account = bankFrm.getBankService().getAccount(accountNumber);
            bankFrm.getTable().setValueAt(account.getBalance(),selectionIndex, 5);
        }
        dispose();
    }
}

