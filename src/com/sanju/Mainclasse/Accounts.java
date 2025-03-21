package com.sanju.Mainclasse;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

public class Accounts {
    private static final List<Account> accounts = new ArrayList<>();
    
    // Constants for initial account data
    private static final int[] ACCOUNT_NUMBERS = {1040501, 1040502, 1040503};
    private static final double[] INITIAL_BALANCES = {5000.55, 7000.5, 10000.50};
    
    // Private constructor to prevent instantiation
    private Accounts() {
        throw new AssertionError("Utility class should not be instantiated");
    }

    static {
        initializeAccounts();
    }

    private static void initializeAccounts() {
        if (ACCOUNT_NUMBERS.length != INITIAL_BALANCES.length) {
            throw new IllegalStateException("Account numbers and balances arrays must have the same length");
        }

        for (int i = 0; i < ACCOUNT_NUMBERS.length; i++) {
            accounts.add(new Account(ACCOUNT_NUMBERS[i], INITIAL_BALANCES[i]));
        }
    }

    /**
     * Returns an unmodifiable view of the accounts list
     */
    public static List<Account> getAccounts() {
        return Collections.unmodifiableList(accounts);
    }

    /**
     * Retrieves an account by its account number
     * @return Optional<Account> containing the account if found, empty otherwise
     */
    public static Optional<Account> getAccountByAccountNo(int targetAccountNo) {
        return accounts.stream()
                .filter(account -> account.getAccountNo() == targetAccountNo)
                .findFirst();
    }

    /**
     * Adds a new account to the list
     * @param account the account to add
     * @throws IllegalArgumentException if account is null or account number already exists
     */
    public static void addAccount(Account account) {
        if (account == null) {
            throw new IllegalArgumentException("Account cannot be null");
        }

        if (accountExists(account.getAccountNo())) {
            throw new IllegalArgumentException("Account number already exists: " + account.getAccountNo());
        }

        accounts.add(account);
    }

    /**
     * Checks if an account with the given account number exists
     * @param accountNo the account number to check
     * @return boolean true if account exists, false otherwise
     */
    public static boolean accountExists(int accountNo) {
        return accounts.stream()
                .anyMatch(account -> account.getAccountNo() == accountNo);
    }

    /**
     * Returns the total number of accounts
     * @return int number of accounts
     */
    public static int getAccountCount() {
        return accounts.size();
    }
}
