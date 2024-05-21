package com.company.core;

import com.company.core.service.AccountService;
import com.company.core.service.AccountServiceImpl;

public class Application {
	public static void main(String[] args) {
		AccountService accountService = new AccountServiceImpl();

		// create 2 accounts;
		accountService.createAccount("1263862","James", AccountType.PERSONAL);
		accountService.createAccount("4253892","Peter",  AccountType.COMPANY);
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
