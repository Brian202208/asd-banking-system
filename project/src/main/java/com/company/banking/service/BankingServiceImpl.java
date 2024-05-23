package com.company.banking.service;

import com.company.framework.domain.Account;
import com.company.framework.domain.AccountEntry;
import com.company.banking.domain.Customer;
import com.company.framework.service.AccountServiceImpl;

import java.util.Collection;


public class BankingServiceImpl extends AccountServiceImpl  implements BankingService{
	private static BankingServiceImpl instance = null;
	private BankingServiceImpl() {}
	public static BankingServiceImpl getInstance() {
		if (instance == null) {
			instance = new BankingServiceImpl();
		}
		return instance;
	}

	public void withdraw(String accountNumber, double amount) {
		withdraw(accountNumber,amount,"Withdraw");
	}


	public void transferFunds(String fromAccountNumber, String toAccountNumber, double amount, String description) {
		Account fromAccount = accountRepository.loadAccount(fromAccountNumber);
		Account toAccount = accountRepository.loadAccount(toAccountNumber);
		fromAccount.transferFunds(toAccount, amount, description);
		accountRepository.updateAccount(fromAccount);
		accountRepository.updateAccount(toAccount);
	}

	public void addInterest() {
		for(Account account: getAllAccounts()){
			account.addInterest();
		}
	}

	public void generateAccountReports() {
		for (Account account : getAllAccounts()) {
			Customer customer = account.getCustomer();
			System.out.println("Statement for Account: " + account.getAccountNumber());
			System.out.println("Account Holder: " + customer.getName());

			System.out.println("-Date-------------------------"
					+ "-Description------------------"
					+ "-Amount-------------");

			for (AccountEntry entry : account.getEntryList()) {
				System.out.printf("%30s%30s%20.2f\n",
						entry.getDate().toString(),
						entry.getDescription(),
						entry.getAmount());
			}

			System.out.println("----------------------------------------" + "----------------------------------------");
			System.out.printf("%30s%30s%20.2f\n\n", "", "Current Balance:", account.getBalance());
		}
	}
}
