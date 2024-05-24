package com.company.ui;

import com.company.banking.service.BankingServiceImpl;
import com.company.creditcard.service.CreditCardAccountServiceImpl;
import com.company.ui.bank.BankFrm;
import com.company.ui.ccard.CardFrm;

import javax.swing.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class FrameworkUserInterface extends JFrame {
    private BankFrm bankFrm;
    private CardFrm cardFrm;

    public FrameworkUserInterface(BankingServiceImpl bankAccountService, CreditCardAccountServiceImpl creditCardService) {
        JButton bankButton = new JButton("Go to Bank Application");
        JButton cardButton = new JButton("Go to Credit Card Application");

        bankButton.addActionListener(e -> {
            if (bankFrm == null || !bankFrm.isVisible()) {
                bankFrm = new BankFrm();
                bankFrm.setVisible(true);
                cardButton.setEnabled(false); // Disable the other button
                this.setVisible(false); // Hide the main window

                bankFrm.addWindowListener(new WindowAdapter() {
                    @Override
                    public void windowClosing(WindowEvent e) {
                        cardButton.setEnabled(true); // Re-enable the other button when the window is closed
                    }
                });
            }
        });

        cardButton.addActionListener(e -> {
            if (cardFrm == null || !cardFrm.isVisible()) {
                cardFrm = new CardFrm();
                cardFrm.setVisible(true);
                bankButton.setEnabled(false); // Disable the other button
                this.setVisible(false); // Hide the main window

                cardFrm.addWindowListener(new WindowAdapter() {
                    @Override
                    public void windowClosing(WindowEvent e) {
                        bankButton.setEnabled(true); // Re-enable the other button when the window is closed
                    }
                });
            }
        });

        this.setLayout(new java.awt.GridLayout(2, 1));
        this.add(bankButton);
        this.add(cardButton);
        this.setSize(400, 200);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Terminate the application when the MainWindow is closed
    }
}