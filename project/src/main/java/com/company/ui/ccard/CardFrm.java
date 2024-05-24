package com.company.ui.ccard;

import com.company.ui.bank.BankFrm;
import com.company.ui.bank.components.JDialog_BankAcc_Deposit;
import com.company.ui.bank.components.JDialog_BankAcc_Withdraw;
import com.company.ui.ccard.components.JDialog_CCAcc_Charge;
import com.company.ui.ccard.components.JDialog_CCAcc_Deposit;
import com.company.ui.framework.BaseUIFrame;

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

	private void withdrawButtonAction(ActionEvent actionEvent) {
		int selection = table.getSelectionModel().getMinSelectionIndex();
		if (selection >=0) {
			String accnr = (String) model.getValueAt(selection, 0);

			//Show the dialog for adding withdraw amount for the current mane
			JDialog_CCAcc_Charge dp = new JDialog_CCAcc_Charge(this, accnr);
			dp.setBounds(430, 15, 275, 140);
			dp.show();
		}
	}

	private void depositButtonAction(ActionEvent actionEvent) {
		int selection = table.getSelectionModel().getMinSelectionIndex();
		if (selection >=0) {
			String accnr = (String) model.getValueAt(selection, 0);

			//Show the dialog for adding withdraw amount for the current mane
			JDialog_CCAcc_Deposit dp = new JDialog_CCAcc_Deposit(this, accnr);
			dp.setBounds(430, 15, 275, 140);
			dp.show();
		}
	}


	private void addCCAccountButtonAction(ActionEvent actionEvent) {
	}

	private void generateBillButtonAction(ActionEvent actionEvent) {
	}



	@Override
	protected void addColumns() {
		model.addColumn("Name");
		model.addColumn("CC number");
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



}
