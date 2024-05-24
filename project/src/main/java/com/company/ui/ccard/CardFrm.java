package com.company.ui.ccard;

import com.company.banking.service.BankingService;
import com.company.creditcard.service.CreditCardAccountService;
import com.company.creditcard.service.CreditCardAccountServiceImpl;
import com.company.ui.bank.BankFrm;
import com.company.ui.bank.components.JDialog_AddPAcc;
import com.company.ui.bank.components.JDialog_BankAcc_Deposit;
import com.company.ui.bank.components.JDialog_BankAcc_Withdraw;
import com.company.ui.ccard.components.JDialog_AddCCAccount;
import com.company.ui.ccard.components.JDialog_CCAcc_Charge;
import com.company.ui.ccard.components.JDialog_CCAcc_Deposit;
import com.company.ui.framework.BaseUIFrame;
import com.company.ui.framework.components.JDialog_AddAccount;
import com.company.ui.framework.components.JDialog_Transaction;
import lombok.Getter;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.WindowEvent;

/**
 * A basic JFC based application.
 */

public class CardFrm extends BaseUIFrame {
	private JButton btnAddCCAccount;
	private JButton btnGenerateBill;
	private JButton btnDeposit;
	private JButton btnWithdraw;
	private JButton btnExit;
	@Getter
	private CreditCardAccountService creditCardAccountService;


	public static void main(String[] args) {
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
			SwingUtilities.invokeLater(() -> {
				CardFrm bankFrm = new CardFrm();
				bankFrm.setVisible(true);
			});
		} catch (Exception e) {
			e.printStackTrace();
			System.exit(1);
		}
	}

	public CardFrm() {
		super();
		creditCardAccountService = CreditCardAccountServiceImpl.getInstance();
		btnAddCCAccount = new JButton("Add Credit-card account");
		btnGenerateBill = new JButton("Generate Monthly bills");
		btnDeposit = new JButton("Deposit");
		btnWithdraw = new JButton("Charge");
		btnExit = new JButton("Exit");

		addButtonToPanel(getPanel(), btnAddCCAccount, 24, 20, 192, 33);
		addButtonToPanel(getPanel(), btnGenerateBill, 240, 20, 192, 33);
		addButtonToPanel(getPanel(), btnDeposit, 468, 104, 96, 33);
		addButtonToPanel(getPanel(), btnWithdraw, 468, 164, 96, 33);
		addButtonToPanel(getPanel(), btnExit, 468, 248, 96, 31);

		addWindowClosingListener();
		addButtonListener(btnExit, this::exitButtonAction);
		addButtonListener(btnAddCCAccount, this::addCCAccountButtonAction);
		addButtonListener(btnGenerateBill, this::generateBillButtonAction);
		addButtonListener(btnDeposit, this::depositButtonAction);
		addButtonListener(btnWithdraw, this::withdrawButtonAction);
	}



	private void addCCAccountButtonAction(ActionEvent actionEvent) {
		JDialog_AddAccount pac = new JDialog_AddCCAccount(this);
		pac.setBounds(450, 20, 300, 330);
		pac.show();
	}

	private void generateBillButtonAction(ActionEvent actionEvent) {
		creditCardAccountService.generateMonthlyBillingReport();
	}



	@Override
	protected void addColumns() {
		model.addColumn("CC number");
		model.addColumn("Name");
		model.addColumn("Exp date");
		model.addColumn("Type");
		model.addColumn("Balance");
	}

	@Override
	protected int getColumnCount() {
		return 5;
	}

	@Override
	protected void windowClosing(WindowEvent event) {
		exitApplication();
	}

	@Override
	protected JDialog_Transaction templateWithDrawMethod(String accnr) {
		return new JDialog_CCAcc_Charge(this, accnr);
	}

	@Override
	protected JDialog_Transaction templateDepositMethod(String accnr) {
		return new JDialog_CCAcc_Deposit(this, accnr);
	}


}
