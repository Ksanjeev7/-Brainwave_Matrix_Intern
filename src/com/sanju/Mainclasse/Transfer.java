package com.sanju.Mainclasse;

import java.util.Optional;
import java.util.Scanner;

public class Transfer {
	public static void execute(Account sourceAccount, Scanner scanner) {
	    try {
	        // Validate source account
	        if (sourceAccount == null) {
	            throw new IllegalArgumentException("Source account cannot be null");
	        }

	        // Get target account number with input validation
	        System.out.println("Enter Account Number to Transfer:");
	        while (!scanner.hasNextInt()) {
	            System.out.println("Invalid input. Please enter a valid account number:");
	            scanner.next(); // Clear invalid input
	        }
	        int targetAccountNo = scanner.nextInt();
	        scanner.nextLine(); // Clear the buffer

	        // Get target account
	        Optional<Account> optionalTargetAccount = Accounts.getAccountByAccountNo(targetAccountNo);

	        if (optionalTargetAccount.isPresent()) {
	            Account targetAccount = optionalTargetAccount.get();
	            
	            // Prevent transfer to same account
	            if (sourceAccount.getAccountNo() == targetAccountNo) {
	                System.out.println("Error: Cannot transfer to the same account");
	                return;
	            }

	            // Get transfer amount with input validation
	            double transferAmount = getValidTransferAmount(scanner);

	            try {
	                sourceAccount.transfer(targetAccount, transferAmount);
	                System.out.printf("Successfully transferred $%.2f to account: %d%n", 
	                                transferAmount, targetAccountNo);
	                System.out.printf("Your current balance: $%.2f%n", 
	                                sourceAccount.getBalance());
	            } catch (InsufficientBalanceException e) {
	                System.out.println("Error: " + e.getMessage());
	            } catch (IllegalArgumentException e) {
	                System.out.println("Error: Invalid transfer amount - " + e.getMessage());
	            }
	        } else {
	            System.out.println("Error: Transfer account number not found");
	        }
	    } catch (Exception e) {
	        System.out.println("An error occurred during transfer: " + e.getMessage());
	        scanner.nextLine(); // Clear the buffer
	    }
	}

	/**
	 * Helper method to get and validate transfer amount
	 */
	private static double getValidTransferAmount(Scanner scanner) {
	    double amount = 0;
	    boolean validInput = false;

	    while (!validInput) {
	        System.out.println("Enter amount to Transfer:");
	        try {
	            if (scanner.hasNextDouble()) {
	                amount = scanner.nextDouble();
	                if (amount <= 0) {
	                    System.out.println("Amount must be greater than zero");
	                } else {
	                    validInput = true;
	                }
	            } else {
	                System.out.println("Please enter a valid number");
	                scanner.next(); // Clear invalid input
	            }
	        } catch (Exception e) {
	            System.out.println("Invalid input. Please try again");
	            scanner.next(); // Clear invalid input
	        }
	    }
	    scanner.nextLine(); // Clear the buffer
	    return amount;
	    
	}
}
