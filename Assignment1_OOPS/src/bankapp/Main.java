package bankapp;

import java.util.Scanner;

import bankapp.service.*;
import bankapp.model.*;

public class Main {
    public static void main(String[] args) {
        AccountManager accountManager = new AccountManager();
        Scanner sc = new Scanner(System.in);
        int choice;
        
        System.out.println("=== Welcome to " + "Young Dragon Bank" + " ===");
        
        do {
            System.out.println("\n=== Bank Account Management System ===");
            System.out.println("1. Add Account");
            System.out.println("2. Deposit");
            System.out.println("3. Withdraw");
            System.out.println("4. Display Account Details");
            System.out.println("5. Calculate Interest");
            System.out.println("6. Get Account Count");
            System.out.println("7. Get Balance");
            System.out.println("8. Display All Accounts");
            System.out.println("0. Exit");
            System.out.print("Enter your choice: ");
            
            choice = sc.nextInt();
            sc.nextLine();
            
            switch (choice) {
                case 1:
                    System.out.print("Enter Account Number: ");
                    String accountNumber = sc.nextLine();
                    System.out.print("Enter Account Holder Name: ");
                    String accountHolderName = sc.nextLine();
                    System.out.print("Enter Initial Balance: Rs.");
                    double initialBalance = sc.nextDouble();
                    accountManager.addAccount(accountNumber, accountHolderName, initialBalance);
                    break;
                    
                case 2:
                    System.out.print("Enter Account Number: ");
                    String depositAccountNumber = sc.nextLine();
                    System.out.print("Enter Deposit Amount: Rs.");
                    double depositAmount = sc.nextDouble();
                    accountManager.deposit(depositAccountNumber, depositAmount);
                    break;
                    
                case 3:
                    System.out.print("Enter Account Number: ");
                    String withdrawAccountNumber = sc.nextLine();
                    System.out.print("Enter Withdrawal Amount: Rs.");
                    double withdrawAmount = sc.nextDouble();
                    accountManager.withdraw(withdrawAccountNumber, withdrawAmount);
                    break;
                    
                case 4:
                    System.out.print("Enter Account Number: ");
                    String displayAccountNumber = sc.nextLine();
                    accountManager.displayAccountDetails(displayAccountNumber);
                    break;
                    
                case 5:
                    System.out.print("Enter Account Number: ");
                    String interestAccountNumber = sc.nextLine();
                    accountManager.calculateInterest(interestAccountNumber);
                    break;
                    
                case 6:
                    System.out.println("Total number of accounts: " + Account.getAccountCount());
                    break;
                    
                case 7:
                    System.out.print("Enter Account Number: ");
                    String balanceAccountNumber = sc.nextLine();
                    accountManager.getBalance(balanceAccountNumber);
                    break;
                    
                    
                case 0:
                    System.out.println("Thank you for using Young Dragon Bank!");
                    break;
                    
                default:
                    System.out.println("Invalid choice! Please try again.");
            }
        } while (choice != 0);
        
        sc.close();
    }
}
