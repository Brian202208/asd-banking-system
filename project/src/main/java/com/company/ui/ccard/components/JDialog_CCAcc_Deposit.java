package com.company.ui.ccard.components;

import com.company.framework.domain.Account;
import com.company.ui.bank.BankFrm;
import com.company.ui.ccard.CardFrm;
import com.company.ui.framework.components.JDialog_Transaction;

import java.util.Objects;

public class JDialog_CCAcc_Deposit extends JDialog_Transaction {

    public JDialog_CCAcc_Deposit(CardFrm parent, String aname) {
        super(parent, aname, "Pay Bills");
    }

    @Override
    protected void JButtonOK_actionPerformed(java.awt.event.ActionEvent event) {
        CardFrm cardFrm = (CardFrm) parentframe;
        int selectionIndex = cardFrm.getTable().getSelectionModel().getMinSelectionIndex();
        if(selectionIndex >= 0){
            String accountNumber = (String)cardFrm.getModel().getValueAt(selectionIndex, 0);
            String amount = JTextField_AMT.getText();

            cardFrm.getCreditCardAccountService().charge(accountNumber, Objects.isNull(amount) ? 0: Double.parseDouble(amount)*(-1));

            Account account = cardFrm.getCreditCardAccountService().getAccount(accountNumber);
            cardFrm.getTable().setValueAt(account.getBalance(),selectionIndex, 4);
        }
        dispose();
    }
}