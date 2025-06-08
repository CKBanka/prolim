package bankapp.service;

import bankapp.model.Account;

public class AccountManager {
    private Account[] accounts;
    private int accountIndex;
    private final int MAX_ACCOUNTS = 100;
    
    public AccountManager() {
        accounts = new Account[MAX_ACCOUNTS];
        accountIndex = 0;
    }
    
    public void addAccount(String accountNumber, String accountHolderName, double initialBalance) {
        if (accountIndex < MAX_ACCOUNTS) {
            // Check if account number already exists
            for (int i = 0; i < accountIndex; i++) {
                if (accounts[i].getAccountNumber().equals(accountNumber)) {
                    System.out.println("Account number already exists!");
                    return;
                }
            }
            
            accounts[accountIndex] = new Account(accountNumber, accountHolderName, initialBalance);
            System.out.println("Account created successfully!");
            accounts[accountIndex].displayAccountDetails();
            accountIndex++;
        } else {
            System.out.println("Maximum account limit reached!");
        }
    }
    
    public Account findAccount(String accountNumber) {
        for (int i = 0; i < accountIndex; i++) {
            if (accounts[i].getAccountNumber().equals(accountNumber)) {
                return accounts[i];
            }
        }
        return null;
    }
    
    public void deposit(String accountNumber, double amount) {
        Account account = findAccount(accountNumber);
        if (account != null) {
            account.deposit(amount);
        } else {
            System.out.println("Account not found!");
        }
    }
    
    public void withdraw(String accountNumber, double amount) {
        Account account = findAccount(accountNumber);
        if (account != null) {
            account.withdraw(amount);
        } else {
            System.out.println("Account not found!");
        }
    }
    
    public void displayAccountDetails(String accountNumber) {
        Account account = findAccount(accountNumber);
        if (account != null) {
            account.displayAccountDetails();
        } else {
            System.out.println("Account not found!");
        }
    }
    
    public void calculateInterest(String accountNumber) {
        Account account = findAccount(accountNumber);
        if (account != null) {
            double interest = account.calculateInterest();
            System.out.println("Annual Interest for Account " + accountNumber + ": $" + String.format("%.2f", interest));
        } else {
            System.out.println("Account not found!");
        }
    }
    
    public void getBalance(String accountNumber) {
        Account account = findAccount(accountNumber);
        if (account != null) {
            System.out.println("Balance for Account " + accountNumber + ": $" + account.getBalance());
        } else {
            System.out.println("Account not found!");
        }
    }
    
    public void displayAllAccounts() {
        if (accountIndex == 0) {
            System.out.println("No accounts found!");
            return;
        }
        
        System.out.println("\n=== All Accounts ===");
        for (int i = 0; i < accountIndex; i++) {
            accounts[i].displayAccountDetails();
        }
    }
}
