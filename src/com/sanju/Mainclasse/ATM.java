package com.sanju.Mainclasse;

import java.util.Scanner;

import com.sanju.CustomerDetails;

public class ATM {
	private static final int MAX_LOGIN_ATTEMPTS = 3;
	private static final String WELCOME_MESSAGE = "Welcome to ATM. Please enter your Account_No and PIN to continue...";
	private static final String LOGIN_SUCCESS = "Login Successful!";
	private static final String INVALID_CREDENTIALS = "Wrong PIN or Account Number. You have %d attempts remaining.";
	private static final String ACCOUNT_BLOCKED = "Sorry, you've exceeded the maximum number of attempts. Your account is now blocked.";
	private final Account account;
	private final CustomerDetails customerDetails;
	private final Scanner scanner;
	private final ATMOperations atmOperations;

	public ATM() {
		this.account = new Account(1000);
		this.customerDetails = new CustomerDetails();
		this.scanner = new Scanner(System.in);
		this.atmOperations = new ATMOperations(account, scanner);
	}

	public void start() {
		System.out.println(WELCOME_MESSAGE);
		processLogin();
		scanner.close();
	}

	private void processLogin() {
		for (int attempts = 1; attempts <= MAX_LOGIN_ATTEMPTS; attempts++) {
			if (authenticateUser()) {
				System.out.println(LOGIN_SUCCESS);
				processTransactions();
				return;
			} else {
				int remainingAttempts = MAX_LOGIN_ATTEMPTS - attempts;
				if (remainingAttempts > 0) {
					System.out.printf(INVALID_CREDENTIALS + "%n", remainingAttempts);
				} else {
					System.out.println(ACCOUNT_BLOCKED);
				}
			}
		}
	}

	private boolean authenticateUser() {
		try {
			System.out.println("Account Number:");
			int accountNo = getValidIntInput();

			System.out.println("Enter PIN:");
			int pin = getValidIntInput();

			return accountNo == customerDetails.getAccountNo() && 
					pin == customerDetails.getPin();
		} catch (Exception e) {
			System.out.println("Invalid input. Please enter numeric values only.");
			scanner.nextLine(); // Clear buffer
			return false;
		}
	}

	private void processTransactions() {
		int userChoice;
		do {
			displayOptionsMenu();
			userChoice = getUserChoice();
			processUserChoice(userChoice);
		} while (userChoice != 5);
	}

	private int getValidIntInput() {
		while (!scanner.hasNextInt()) {
			System.out.println("Please enter a valid number.");
			scanner.next();
		}
		return scanner.nextInt();
	}
	private int getUserChoice() {
		while (true) {
			try {
				System.out.println("Enter your choice (1-5):");
				int choice = getValidIntInput();
				if (choice >= 1 && choice <= 5) {
					return choice;
				}
				System.out.println("Please enter a number between 1 and 5.");
			} catch (Exception e) {
				System.out.println("Invalid input. Please enter a number.");
				scanner.nextLine(); // Clear buffer
			}
		}
	}
	private void processUserChoice(int choice) {
		try {
			switch (choice) {
			case 1 -> atmOperations.handleDeposit();
			case 2 -> atmOperations.handleWithdrawal();
			case 3 -> atmOperations.handleTransfer();
			case 4 -> atmOperations.displayTransactionHistory();
			case 5 -> atmOperations.handleExit();
			default -> throw new IllegalArgumentException("Invalid choice: " + choice);
			}
		} catch (Exception e) {
			System.out.println("Error processing transaction: " + e.getMessage());
		}
	}

	private static void displayOptionsMenu() {
		System.out.println("\nOptions Menu:");
		System.out.println("1. Deposit");
		System.out.println("2. Withdraw");
		System.out.println("3. Transfer");
		System.out.println("4. Display Transaction History");
		System.out.println("5. Exit");
	}
	
	public static void main(String[] args) {
	    ATM atm = new ATM();
	    atm.start();
	}
}
