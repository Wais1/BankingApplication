package com.company;

import java.util.Scanner;

public class Main {
    private static Bank bank;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Initialize bank
        System.out.println("What is the name of your bank?");
        String bankName = scanner.nextLine();
        bank = new Bank(bankName);

        // Make a new customer
        makeNewCustomer();

        // Track current customer, that is later dependant on user input
        byte currentCustomerIndex = 0;
        Customer customer = bank.getCustomer(currentCustomerIndex);

        boolean flag = true;
        while (flag) {
            // Display options
            System.out.println("Welcome " + customer.getFirstName() + " " + customer.getLastName() +
                    ", Please select an option\n\n1.Display Balance\n2.Deposit\n3.Withdraw\n4.Select another customer" +
                    "\n5.Make a new Customer\n6.Exit");

            // Prompt selection of options
            byte selection = scanner.nextByte();
            switch (selection) {
                case 1:
                    // Display customer's current balance.
                    System.out.println(customer.getFirstName() + ", Your current balance is $" + customer.getAccount().getBalance());
                    break;
                case 2:
                    // Deposit into the account balance
                    System.out.println("Enter an amount to deposit? (USD)\n");
                    double depositAmount = scanner.nextDouble();
                    customer.getAccount().deposit(depositAmount); // Deposit the amount
                    System.out.println("Your new balance is: $" + customer.getAccount().getBalance()); // Display new balance
                    break;
                case 3:
                    // Withdraw from account balance.
                    System.out.println("Enter an amount to withdraw (USD)\n");
                    double withdrawAmount = scanner.nextDouble();
                    if (customer.getAccount().withdraw(withdrawAmount)) { // Withdraw the amount
                        System.out.println("Your new balance is: $" + customer.getAccount().getBalance()); // Display new balance
                    } else {
                        System.out.println("Sorry, your balance does not meet the minimum requirement to withdraw this amount");
                        System.out.println("Current balance: " + customer.getAccount().getBalance());
                    }
                    break;
                case 4:
                    // Select another customer
                    System.out.println("Select an existing member:");
                    // Print customer list in bank.
                    bank.printCustomerList();
                    // Point to new chosen customer
                    currentCustomerIndex = scanner.nextByte();
                    // Check if customer exists
                    if (currentCustomerIndex < bank.getNumOfCustomers()) {
                        customer = bank.getCustomer(currentCustomerIndex);
                        System.out.println("You have selected " + customer.getFirstName());
                    } else {
                        System.out.println("Sorry, please select an existing member");
                    }
                    break;
                case 5:
                    // Register for a new account.
                    System.out.println("Registering a new account...");
                    makeNewCustomer();
                    break;
                case 6:
                    // Exit the program. End the while loop.
                    System.out.println("Thank you for using " + bank.getBankName() + ", have a great day.");
                    flag = false;
                    System.exit(0);
                    break;
                default:
                    System.out.println("Please try a value within the range");
            }
        }
    }

    // Helper method to create new customer and add to bank.
    private static void makeNewCustomer() {
        Scanner scanner = new Scanner(System.in);

        // Receive name input
        System.out.println("What's your first name?");
        String fName = scanner.next();

        System.out.println("What's your last name?");
        String lName = scanner.next();

        // Connects Account to customer with a deposit
        // Add customer to bank data
        bank.addCustomer(fName, lName);
    }
}
