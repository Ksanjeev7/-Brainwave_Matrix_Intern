package com.sanju.Mainclasse;

import java.util.ArrayList;
import java.util.List;

public class Account {
    private double balance;
    private int accountNo;
    private List<Transaction> transactionHistory;

    // Constants for transaction types
    private static final String DEPOSIT = "Deposit";
    private static final String WITHDRAWAL = "Withdrawal";
    private static final String TRANSFER = "Transfer";
    
    // Exception messages
    private static final String INSUFFICIENT_BALANCE = "Insufficient balance for the operation.";

    // Constructor with all fields
    public Account(int accountNo, double initialBalance) {
        validateInitialBalance(initialBalance);
        this.accountNo = accountNo;
        this.balance = initialBalance;
        this.transactionHistory = new ArrayList<>();
    }

    // Constructor with only balance
    public Account(double initialBalance) {
        this(0, initialBalance); // Using constructor chaining
    }

    // Default constructor
    public Account() {
        this(0, 0.0); // Using constructor chaining
    }

    public int getAccountNo() {
        return accountNo;
    }

    public double getBalance() {
        return balance;
    }

    public void deposit(double amount) {
        validateAmount(amount);
        balance += amount;
        recordTransaction(DEPOSIT, amount);
    }

    public void withdraw(double amount) {
        validateAmount(amount);
        if (canWithdraw(amount)) {
            balance -= amount;
            recordTransaction(WITHDRAWAL, amount);
        } else {
            throw new InsufficientBalanceException(INSUFFICIENT_BALANCE);
        }
    }

    public void transfer(Account targetAccount, double amount) {
        validateAmount(amount);
        if (canWithdraw(amount)) {
            balance -= amount;
            targetAccount.deposit(amount);
            recordTransaction(TRANSFER, amount, targetAccount.getAccountNo());
        } else {
            throw new InsufficientBalanceException(INSUFFICIENT_BALANCE);
        }
    }

    public void displayTransactionHistory() {
        System.out.println("Transaction History:");
        transactionHistory.forEach(System.out::println);
        System.out.printf("Current Balance: %.2f%n", balance);
    }

    private void recordTransaction(String type, double amount) {
        transactionHistory.add(new Transaction(type, amount));
    }

    private void recordTransaction(String type, double amount, int targetAccountNo) {
        transactionHistory.add(new Transaction(type, amount, targetAccountNo));
    }

    private boolean canWithdraw(double amount) {
        return balance >= amount;
    }

    private void validateAmount(double amount) {
        if (amount <= 0) {
            throw new IllegalArgumentException("Amount must be positive");
        }
    }

    private void validateInitialBalance(double initialBalance) {
        if (initialBalance < 0) {
            throw new IllegalArgumentException("Initial balance cannot be negative");
        }
    }
}

class InsufficientBalanceException extends RuntimeException {

	private static final long serialVersionUID = 8736753274505553406L;

	public InsufficientBalanceException(String message) {
        super(message);
    }
}
