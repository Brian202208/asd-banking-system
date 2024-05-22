package com.company.banking;

import com.company.banking.domain.Account;
import com.company.banking.domain.AccountType;
import com.company.banking.domain.Customer;
import com.company.banking.domain.bankaccount.CompanyAccount;
import com.company.banking.domain.bankaccount.PersonalAccount;
import com.company.banking.service.AccountServiceImpl;
import com.company.banking.service.AccountService;

public class Application {
	public static void main(String[] args) {

		AccountService accountService = new AccountServiceImpl();
		// create 2 accounts;
		Customer customer = new Customer("James");

		Account personalAccount1 = new PersonalAccount("1263862");
		personalAccount1.setCustomer(customer);

		accountService.createAccount(personalAccount1);

		Account companyAccount = new CompanyAccount("4253892");
		companyAccount.setCustomer(customer);

		accountService.createAccount(companyAccount);

		// use account 1;
		accountService.deposit("1263862", 240);
		accountService.deposit("1263862", 529);
		accountService.withdraw("1263862", 230);

		// use account 2;
		accountService.deposit("4253892", 12450);
		accountService.transferFunds("4253892", "1263862", 100, "payment of invoice 10232");
		// show balances
		//Generate Account Reports
		accountService.generateAccountReports();

		//Add interest
		accountService.addInterest();


		//Generated Account Reports with Interest
		accountService.generateAccountReports();
	}

}
