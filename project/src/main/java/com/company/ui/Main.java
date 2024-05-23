package com.company.ui;

import com.company.banking.service.BankingServiceImpl;
import com.company.creditcard.service.CreditCardAccountServiceImpl;
import lombok.SneakyThrows;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {

        BankingServiceImpl bankingService = BankingServiceImpl.getInstance();
        CreditCardAccountServiceImpl creditCardAccountService = CreditCardAccountServiceImpl.getInstance();

        initializeUI(bankingService, creditCardAccountService);
    }

    @SneakyThrows
    private static void initializeUI(BankingServiceImpl bankingService, CreditCardAccountServiceImpl creditCardService) {
        UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());

        (new FrameworkUserInterface(bankingService, creditCardService)).setVisible(true);
    }
}