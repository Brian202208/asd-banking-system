package com.company.ui.bank;

import com.company.banking.service.BankingServiceImpl;
import com.company.ui.bank.components.JDialog_AddCompAcc;
import com.company.ui.bank.components.JDialog_AddPAcc;
import com.company.ui.bank.components.JDialog_BankAcc_Deposit;
import com.company.ui.bank.components.JDialog_BankAcc_Withdraw;
import com.company.ui.framework.BaseUIFrame;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.WindowEvent;

/**
 * A basic JFC based application.
 */
public class BankFrm extends BaseUIFrame {

    public static void main(String[] args) {
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
            SwingUtilities.invokeLater(() -> {
                BankFrm bankFrm = new BankFrm();
                bankFrm.setVisible(true);
            });
        } catch (Exception e) {
            e.printStackTrace();
            System.exit(1);
        }
    }

    private BankingServiceImpl bankService;
    private JButton btnPersonalAccount;
    private JButton btnCompanyAccount;
    private JButton btnDeposit;
    private JButton btnWithdraw;
    private JButton btnAddInterest;
    private JButton btnExit;

    public BankFrm() {
        super();
        bankService = BankingServiceImpl.getInstance();

        btnPersonalAccount = new JButton("Add personal account");
        btnCompanyAccount = new JButton("Add company account");
        btnDeposit = new JButton("Deposit");
        btnWithdraw = new JButton("Withdraw");
        btnAddInterest = new JButton("Add interest");
        btnExit = new JButton("Exit");

        addButtonToPanel(getPanel(), btnPersonalAccount, 24, 20, 192, 33);
        addButtonToPanel(getPanel(), btnCompanyAccount, 240, 20, 192, 33);
        addButtonToPanel(getPanel(), btnDeposit, 468, 104, 96, 33);
        addButtonToPanel(getPanel(), btnWithdraw, 468, 164, 96, 33);
        addButtonToPanel(getPanel(), btnAddInterest, 448, 20, 106, 33);
        addButtonToPanel(getPanel(), btnExit, 468, 248, 96, 31);

        addWindowClosingListener();
        addButtonListener(btnExit, this::exitButtonAction);
        addButtonListener(btnPersonalAccount, this::addPersonalAccountAction);
        addButtonListener(btnCompanyAccount, this::addCompanyAccountAction);
        addButtonListener(btnDeposit, this::depositButtonAction);
        addButtonListener(btnWithdraw, this::withdrawButtonAction);
        addButtonListener(btnAddInterest, this::addInterestButtonAction);
    }

    private void addInterestButtonAction(ActionEvent actionEvent) {
    }

    private void withdrawButtonAction(ActionEvent actionEvent) {
        int selection = table.getSelectionModel().getMinSelectionIndex();
        if (selection >=0) {
            String accnr = (String) model.getValueAt(selection, 0);

            //Show the dialog for adding withdraw amount for the current mane
            JDialog_BankAcc_Withdraw dp = new JDialog_BankAcc_Withdraw(this, accnr);
            dp.setBounds(430, 15, 275, 140);
            dp.show();
        }
    }

    private void depositButtonAction(ActionEvent actionEvent) {
        int selection = table.getSelectionModel().getMinSelectionIndex();
        if (selection >=0) {
            String accnr = (String) model.getValueAt(selection, 0);

            //Show the dialog for adding withdraw amount for the current mane
            JDialog_BankAcc_Deposit dp = new JDialog_BankAcc_Deposit(this, accnr);
            dp.setBounds(430, 15, 275, 140);
            dp.show();
        }
    }

    private void addCompanyAccountAction(ActionEvent actionEvent) {
        JDialog_AddCompAcc pac = new JDialog_AddCompAcc(this);
        pac.setBounds(450, 20, 300, 330);
        pac.show();

        if (newAccount) {
            // add row to table
            // Your implementation here
        }
    }

    private void addPersonalAccountAction(ActionEvent event) {
        JDialog_AddPAcc pac = new JDialog_AddPAcc(this);
        pac.setBounds(450, 20, 300, 330);
        pac.show();

        if (newAccount) {
            // add row to table
            // Your implementation here
        }
    }

    // Implement other button action methods

    @Override
    protected void windowClosing(WindowEvent event) {
        exitApplication();
    }

    @Override
    protected void addColumns() {
        model.addColumn("AccountNr");
        model.addColumn("Name");
        model.addColumn("City");
        model.addColumn("P/C");
        model.addColumn("Ch/S");
        model.addColumn("Amount");
    }

    @Override
    protected int getColumnCount() {
        return 6;
    }



}
