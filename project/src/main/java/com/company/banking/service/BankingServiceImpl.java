package com.company.banking.service;

import com.company.banking.domain.Account;
import com.company.banking.domain.AccountEntry;
import com.company.banking.domain.Customer;
import com.company.banking.repository.AccountRepository;
import com.company.banking.repository.AccountRepositoryImpl;
import com.company.banking.integration.EmailSender;

import java.util.Collection;

public class BankingServiceImpl implements BankingService {
	private final AccountRepository accountRepository;

	public BankingServiceImpl(){
		accountRepository = new AccountRepositoryImpl();
	}

	public void createAccount(Account account) {
		accountRepository.saveAccount(account);
		account.registerObserver(new EmailSender());
	}

	public void deposit(String accountNumber, double amount) {
		Account account = accountRepository.loadAccount(accountNumber);
		account.deposit(amount);
		accountRepository.updateAccount(account);
	}

	public Account getAccount(String accountNumber) {
		Account account = accountRepository.loadAccount(accountNumber);
		return account;
	}

	public Collection<Account> getAllAccounts() {
		return accountRepository.getAccounts();
	}

	public void withdraw(String accountNumber, double amount) {
		Account account = accountRepository.loadAccount(accountNumber);
		account.withdraw(amount,"Withdraw");
		accountRepository.updateAccount(account);
	}



	public void transferFunds(String fromAccountNumber, String toAccountNumber, double amount, String description) {
		Account fromAccount = accountRepository.loadAccount(fromAccountNumber);
		Account toAccount = accountRepository.loadAccount(toAccountNumber);
		fromAccount.transferFunds(toAccount, amount, description);
		accountRepository.updateAccount(fromAccount);
		accountRepository.updateAccount(toAccount);
	}

	@Override
	public void addInterest() {
		for(Account account: getAllAccounts()){
			account.addInterest();
		}
	}

	@Override
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
