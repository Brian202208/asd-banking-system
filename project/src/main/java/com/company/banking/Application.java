package com.company.banking;

import com.company.common.Customer;
import com.company.banking.domain.BankAccount;
import com.company.banking.domain.CompanyAccount;
import com.company.banking.service.BankingServiceImpl;
import com.company.banking.service.BankingService;
import com.company.banking.strategy.CheckingAccountStrategy;
import com.company.banking.strategy.SavingsAccountStrategy;
import com.company.framework.domain.AccountType;
import com.company.patterns.factory.BankingAccountFactory;

public class Application {
	public static void main(String[] args) {

		BankingService bankingService = BankingServiceImpl.getInstance();
		// create 2 accounts;
		Customer customer = new Customer("James");

		BankingAccountFactory factory = new BankingAccountFactory();

		BankAccount personalAccount1 = factory.createAccount(AccountType.PERSONAL,"1263862",customer);

		personalAccount1.setStrategy(new CheckingAccountStrategy());

		bankingService.createAccount(personalAccount1);
		// use account 1;
		bankingService.deposit("1263862", 240);
		bankingService.deposit("1263862", 529);
		bankingService.withdraw("1263862", 800.00);

		BankAccount companyAccount = new CompanyAccount("4253892");
		companyAccount.setStrategy(new SavingsAccountStrategy());
		companyAccount.setCustomer(customer);

		bankingService.createAccount(companyAccount);
		// use account 2;
		bankingService.deposit("4253892", 12);
		bankingService.transferFunds("4253892", "1263862", 100, "payment of invoice 10232");

		// show balances
		//Generate Account Reports
		bankingService.generateAccountReports();
		//Add interest
		bankingService.addInterest();
		//Generated Account Reports with Interest
		bankingService.generateAccountReports();
	}
}
