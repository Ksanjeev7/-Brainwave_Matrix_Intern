package com.sanju.Mainclasse;

import java.util.Scanner;

public class Deposit {
	
	
	public static void execute(Account account, Scanner scanner) {

		    System.out.println("Enter Amount to Deposit:");
	        double depositAmount = scanner.nextDouble();
	        account.deposit(depositAmount);
	        System.out.println("Deposited Successfully...");
		
		
	 }
}
