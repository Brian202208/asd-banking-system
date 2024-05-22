package com.company.banking;

import com.company.banking.domain.Account;
import com.company.banking.domain.Customer;
import com.company.banking.domain.bankaccount.CompanyAccount;
import com.company.banking.domain.bankaccount.PersonalAccount;
import com.company.banking.service.BankingServiceImpl;
import com.company.banking.service.BankingService;

public class Application {
	public static void main(String[] args) {

		BankingService bankingService = new BankingServiceImpl();
		// create 2 accounts;
		Customer customer = new Customer("James");

		Account personalAccount1 = new PersonalAccount("1263862");
		personalAccount1.setCustomer(customer);

		bankingService.createAccount(personalAccount1);

		Account companyAccount = new CompanyAccount("4253892");
		companyAccount.setCustomer(customer);

		bankingService.createAccount(companyAccount);

		// use account 1;
		bankingService.deposit("1263862", 240);
		bankingService.deposit("1263862", 529);
		bankingService.withdraw("1263862", 230);

		// use account 2;
		bankingService.deposit("4253892", 12450);
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
