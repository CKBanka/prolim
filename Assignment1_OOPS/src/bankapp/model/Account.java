package bankapp.model;


import bankapp.util.*;

public class Account extends BankAccount implements Transaction {
    private double balance;
    private final String BANK_NAME = "Young Dragon Bank";
    private static int accountCount = 0;
    
    public Account(String accountNumber, String accountHolderName, double initialBalance) {
        super(accountNumber, accountHolderName);
        this.balance = initialBalance;
        accountCount++;
    }
    
    public double getBalance() {
        return balance;
    }
    
    public void setBalance(double balance) {
        if (balance >= 0) {
            this.balance = balance;
        } else {
            System.out.println("Balance cannot be negative!");
        }
    }
    
    public final String getBankName() {
        return BANK_NAME;
    }
    
    public static int getAccountCount() {
        return accountCount;
    }
    
    @Override
    public double calculateInterest() {
        return balance * 0.05;
    }
    
    @Override
    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Successfully deposited Rs." + amount);
            System.out.println("New balance: Rs." + balance);
        } else {
            System.out.println("Deposit amount must be positive!");
        }
    }
    
    @Override
    public void withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            System.out.println("Successfully withdrawn Rs." + amount);
            System.out.println("New balance: Rs." + balance);
        } else if (amount > balance) {
            System.out.println("Insufficient funds! Current balance: Rs." + balance);
        } else {
            System.out.println("Withdrawal amount must be positive!");
        }
    }
    
    public void displayAccountDetails() {
        System.out.println("\n--- Account Details ---");
        System.out.println("Account Number: " + accountNumber);
        System.out.println("Account Holder: " + accountHolderName);
        System.out.println("Balance: Rs." + balance);
        System.out.println("Bank: " + getBankName());
        System.out.println("Annual Interest: Rs." + String.format("%.2f", calculateInterest()));
        System.out.println("----------------------");
    }
}