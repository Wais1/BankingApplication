package com.company;

public class Bank {
    private Customer[] customers;
    private int numberOfCustomers;
    private String bankName;

    public Bank(String bName){
        bankName = bName;
        customers = new Customer[900]; // Initialize array with max capacity
        numberOfCustomers = 0;
    }


    public void addCustomer(String f, String l){
        customers[numberOfCustomers] = new Customer(f,l);

        Account acc = new Account(0);   // Initialize account and connect with customer
        customers[numberOfCustomers].setAccount(acc);

        numberOfCustomers++; // Increment number of customers.
    }

    public int getNumOfCustomers(){
        return numberOfCustomers;
    }

    public Customer getCustomer(int index) {
        return customers[index];
    }


    // Extras
    public String getBankName(){
        return bankName;
    }

    // Prints customer list with index.
    public void printCustomerList(){
        for (int i=0; i < numberOfCustomers; i++) {
            System.out.println(i +": " + customers[i].getFirstName() + " " + customers[i].getLastName() +
                    ", Current balance: $" + customers[i].getAccount().getBalance());
        }
    }
}
