package bankapp.service;

import java.util.ArrayList;

import bankapp.model.Account;

public class AccountManager {
    private ArrayList<Account> accounts;
    
    public AccountManager() {
        accounts = new ArrayList<>();
    }
    
    public void addAccount(String accountNumber, String accountHolderName, double initialBalance) {
        for (Account account : accounts) {
            if (account.getAccountNumber().equals(accountNumber)) {
                System.out.println("Account number already exists");
                return;
            }
        }
        
        Account newAccount = new Account(accountNumber, accountHolderName, initialBalance);
        accounts.add(newAccount);
        System.out.println("Account created successfully");
        newAccount.displayAccountDetails();
    }
    
    public Account findAccount(String accountNumber) {
        for (Account account : accounts) {
            if (account.getAccountNumber().equals(accountNumber)) {
                return account;
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
        if (accounts.isEmpty()) {
            System.out.println("No accounts found!");
            return;
        }
        
        System.out.println("\n=== All Accounts ===");
        for (Account account : accounts) {
            account.displayAccountDetails();
        }
    }
    
    public void removeAccount(String accountNumber) {
        Account accountToRemove = findAccount(accountNumber);
        if (accountToRemove != null) {
            accounts.remove(accountToRemove);
            System.out.println("Account " + accountNumber + " removed successfully!");
        } else {
            System.out.println("Account not found!");
        }
    }
    
    public void listAccountsByBalance(double minBalance) {
        System.out.println("\n=== Accounts with balance >= $" + minBalance + " ===");
        boolean found = false;
        for (Account account : accounts) {
            if (account.getBalance() >= minBalance) {
                account.displayAccountDetails();
                found = true;
            }
        }
        if (!found) {
            System.out.println("No accounts found with balance >= $" + minBalance);
        }
    }
    
    public int getTotalAccounts() {
        return accounts.size();
    }
    
    public double getTotalBankBalance() {
        double total = 0.0;
        for (Account account : accounts) {
            total += account.getBalance();
        }
        return total;
    }
}