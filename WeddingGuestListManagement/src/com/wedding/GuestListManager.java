package com.wedding;

import java.util.*;

public class GuestListManager {
    private ArrayList<String> guestList;
    private Scanner scanner;
    
    public GuestListManager() {
        guestList = new ArrayList<>();
        scanner = new Scanner(System.in);
    }
    
    public static void main(String[] args) {
        GuestListManager manager = new GuestListManager();
        manager.runApplication();
    }
    
    public void runApplication() {
        System.out.println("=== WEDDING GUEST LIST MANAGEMENT SYSTEM ===");
        System.out.println("Welcome to the Guest List Manager!");
        
        while (true) {
            displayMenu();
            int choice = getChoice();
            
            switch (choice) {
                case 1:
                    addGuest();
                    break;
                case 2:
                    removeGuestByName();
                    break;
                case 3:
                    updateGuestName();
                    break;
                case 4:
                    searchGuestByName();
                    break;
                case 5:
                    getTotalGuests();
                    break;
                case 6:
                    displayAllGuests();
                    break;
                case 7:
                    insertGuestAtPosition();
                    break;
                case 8:
                    removeGuestByPosition();
                    break;
                case 9:
                    sortGuestListAlphabetically();
                    break;
                case 10:
                    clearGuestList();
                    break;
                case 11:
                    exitApplication();
                    return;
                default:
                    System.out.println(" Invalid choice! Please select a valid option (1-11).");
            }
            
            System.out.println("\nPress Enter to continue...");
            scanner.nextLine();
        }
    }
    
    private void displayMenu() {
        System.out.println("\n" + "=".repeat(50));
        System.out.println("           GUEST LIST MENU OPTIONS");
        System.out.println("=".repeat(50));
        System.out.println("1.   Add Guest");
        System.out.println("2.   Remove Guest by Name");
        System.out.println("3.   Update Guest Name");
        System.out.println("4.   Search Guest by Name");
        System.out.println("5.   Get Total Number of Guests");
        System.out.println("6.   Display All Guests");
        System.out.println("7.   Insert Guest at Specific Position");
        System.out.println("8.   Remove Guest by Position");
        System.out.println("9.   Sort Guest List Alphabetically");
        System.out.println("10.  Clear Guest List");
        System.out.println("11.  Exit the Application");
        System.out.println("=".repeat(50));
        System.out.print("Enter your choice (1-11): ");
    }
    
    private int getChoice() {
        try {
            int choice = scanner.nextInt();
            scanner.nextLine(); 
            return choice;
        } catch (InputMismatchException e) {
            scanner.nextLine(); 
            return -1; 
        }
    }
    
    private void addGuest() {
        System.out.println("\n--- ADD GUEST ---");
        System.out.print("Enter guest name: ");
        String guestName = scanner.nextLine().trim();
        
        if (guestName.isEmpty()) {
            System.out.println(" Guest name cannot be empty!");
            return;
        }
        
        if (guestList.contains(guestName)) {
            System.out.println("  Guest '" + guestName + "' is already in the list!");
        } else {
            guestList.add(guestName);
            System.out.println(" Guest '" + guestName + "' has been added successfully!");
        }
    }
    
    private void removeGuestByName() {
        System.out.println("\n--- REMOVE GUEST BY NAME ---");
        if (guestList.isEmpty()) {
            System.out.println(" Guest list is empty! No guests to remove.");
            return;
        }
        
        System.out.print("Enter guest name to remove: ");
        String guestName = scanner.nextLine().trim();
        
        if (guestList.remove(guestName)) {
            System.out.println(" Guest '" + guestName + "' has been removed successfully!");
        } else {
            System.out.println(" Guest '" + guestName + "' not found in the list!");
        }
    }
    
    private void updateGuestName() {
        System.out.println("\n--- UPDATE GUEST NAME ---");
        if (guestList.isEmpty()) {
            System.out.println(" Guest list is empty! No guests to update.");
            return;
        }
        
        System.out.print("Enter current guest name: ");
        String oldName = scanner.nextLine().trim();
        
        int index = guestList.indexOf(oldName);
        if (index == -1) {
            System.out.println(" Guest '" + oldName + "' not found in the list!");
            return;
        }
        
        System.out.print("Enter new guest name: ");
        String newName = scanner.nextLine().trim();
        
        if (newName.isEmpty()) {
            System.out.println(" New guest name cannot be empty!");
            return;
        }
        
        if (guestList.contains(newName)) {
            System.out.println("  Guest '" + newName + "' already exists in the list!");
            return;
        }
        
        guestList.set(index, newName);
        System.out.println(" Guest name updated from '" + oldName + "' to '" + newName + "'!");
    }
    
    private void searchGuestByName() {
        System.out.println("\n--- SEARCH GUEST BY NAME ---");
        System.out.print("Enter guest name to search: ");
        String guestName = scanner.nextLine().trim();
        
        if (guestList.contains(guestName)) {
            int index = guestList.indexOf(guestName);
            System.out.println(" Guest '" + guestName + "' is invited! (Position: " + (index + 1) + ")");
        } else {
            System.out.println(" Guest '" + guestName + "' is not in the invitation list!");
        }
    }
    
    private void getTotalGuests() {
        System.out.println("\n--- TOTAL GUESTS COUNT ---");
        int totalGuests = guestList.size();
        System.out.println(" Total number of guests: " + totalGuests);
        
        if (totalGuests == 0) {
            System.out.println("The guest list is currently empty.");
        } else if (totalGuests == 1) {
            System.out.println("There is 1 guest in the list.");
        } else {
            System.out.println("There are " + totalGuests + " guests in the list.");
        }
    }
    
    private void displayAllGuests() {
        System.out.println("\n--- ALL GUESTS ---");
        if (guestList.isEmpty()) {
            System.out.println(" No guests in the list yet!");
            return;
        }
        
        System.out.println(" Wedding Guest List (" + guestList.size() + " guests):");
        System.out.println("-".repeat(40));
        for (int i = 0; i < guestList.size(); i++) {
            System.out.println((i + 1) + ". " + guestList.get(i));
        }
        System.out.println("-".repeat(40));
    }
    
    private void insertGuestAtPosition() {
        System.out.println("\n--- INSERT GUEST AT POSITION ---");
        System.out.print("Enter guest name: ");
        String guestName = scanner.nextLine().trim();
        
        if (guestName.isEmpty()) {
            System.out.println(" Guest name cannot be empty!");
            return;
        }
        
        if (guestList.contains(guestName)) {
            System.out.println("  Guest '" + guestName + "' already exists in the list!");
            return;
        }
        
        System.out.print("Enter position (1-" + (guestList.size() + 1) + "): ");
        try {
            int position = scanner.nextInt();
            scanner.nextLine(); 
            
            if (position < 1 || position > guestList.size() + 1) {
                System.out.println(" Invalid position! Please enter a position between 1 and " + (guestList.size() + 1));
                return;
            }
            
            guestList.add(position - 1, guestName);
            System.out.println(" Guest '" + guestName + "' inserted at position " + position + "!");
            
        } catch (InputMismatchException e) {
            scanner.nextLine(); 
            System.out.println(" Invalid input! Please enter a valid number.");
        }
    }
    
    private void removeGuestByPosition() {
        System.out.println("\n--- REMOVE GUEST BY POSITION ---");
        if (guestList.isEmpty()) {
            System.out.println(" Guest list is empty! No guests to remove.");
            return;
        }
        
        System.out.println("Current guests:");
        for (int i = 0; i < guestList.size(); i++) {
            System.out.println((i + 1) + ". " + guestList.get(i));
        }
        
        System.out.print("Enter position to remove (1-" + guestList.size() + "): ");
        try {
            int position = scanner.nextInt();
            scanner.nextLine(); 
            
            if (position < 1 || position > guestList.size()) {
                System.out.println(" Invalid position! Please enter a position between 1 and " + guestList.size());
                return;
            }
            
            String removedGuest = guestList.remove(position - 1);
            System.out.println(" Guest '" + removedGuest + "' removed from position " + position + "!");
            
        } catch (InputMismatchException e) {
            scanner.nextLine(); 
            System.out.println(" Invalid input! Please enter a valid number.");
        }
    }
    
    private void sortGuestListAlphabetically() {
        System.out.println("\n--- SORT GUEST LIST ---");
        if (guestList.isEmpty()) {
            System.out.println(" Guest list is empty! Nothing to sort.");
            return;
        }
        
        System.out.println("Guest list before sorting:");
        displayGuestListNumbered();
        
        Collections.sort(guestList, String.CASE_INSENSITIVE_ORDER);
        
        System.out.println("\n Guest list has been sorted alphabetically!");
        System.out.println("Guest list after sorting:");
        displayGuestListNumbered();
    }
    
    private void displayGuestListNumbered() {
        for (int i = 0; i < guestList.size(); i++) {
            System.out.println((i + 1) + ". " + guestList.get(i));
        }
    }
    
    private void clearGuestList() {
        System.out.println("\n--- CLEAR GUEST LIST ---");
        if (guestList.isEmpty()) {
            System.out.println(" Guest list is already empty!");
            return;
        }
        
        System.out.print("Are you sure you want to clear all guests? (y/n): ");
        String confirmation = scanner.nextLine().trim().toLowerCase();
        
        if (confirmation.equals("y") || confirmation.equals("yes")) {
            int removedCount = guestList.size();
            guestList.clear();
            System.out.println("Guest list cleared! " + removedCount + " guests removed.");
        } else {
            System.out.println(" Operation cancelled. Guest list remains unchanged.");
        }
    }
    
    private void exitApplication() {
        System.out.println("\n--- EXIT APPLICATION ---");
        System.out.println("Thank you for using the Wedding Guest List Management System!");
        System.out.println("Final guest count: " + guestList.size());
        
        if (!guestList.isEmpty()) {
            System.out.println("Your final guest list:");
            displayGuestListNumbered();
        }
        
        System.out.println("Happy wedding!");
        scanner.close();
    }
}