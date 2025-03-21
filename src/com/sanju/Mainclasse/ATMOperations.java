package com.sanju.Mainclasse;

import java.util.Scanner;

public class ATMOperations {
	 private final Account account;
	 private final Scanner scanner;

	    public ATMOperations(Account account, Scanner scanner) {
	        this.account = account;
	        this.scanner = scanner;
	    }

	    public void handleDeposit() {
	        Deposit.execute(account, scanner);
	    }

	    public void handleWithdrawal() {
	        Withdraw.execute(account, scanner);
	    }

	    public void handleTransfer() {
	        Transfer.execute(account, scanner);
	    }

	    public void displayTransactionHistory() {
	        account.displayTransactionHistory();
	    }

	    public void handleExit() {
	        Quit.execute();
	    }
}
