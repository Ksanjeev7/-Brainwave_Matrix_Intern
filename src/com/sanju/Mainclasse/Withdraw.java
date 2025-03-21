package com.sanju.Mainclasse;

import java.util.Scanner;

public class Withdraw {

	public  static void execute(Account account , Scanner scanner) {
		
	System.out.print("Do you want to Confirm Transaction? Yes/No");
        System.out.println("Enter your choice...");
        String choice = scanner.next();

        if ("Yes".equalsIgnoreCase(choice)) {
            System.out.println("Enter Amount to Withdraw:");
            double withdrawAmount = scanner.nextDouble();
            account.withdraw(withdrawAmount);
            System.out.println("Withdraw Successfully...");
        } else {
            System.out.println("Transaction Cancelled");
        }
	}
	
}
