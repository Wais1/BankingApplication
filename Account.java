package com.company;

public class Account {

    private double balance;

    public Account(double balance){
        this.balance = balance;
    }

    public double getBalance(){
        return balance;
    }

    public boolean deposit(double amt){
        if(amt > 0) {
            balance += amt;
            return true;
        }
        return false;
    }

    public boolean withdraw(double amt){
        if(balance >= amt && amt > 0) {    // If balance is greater than amount requested, subtract amount from balance.
            balance -= amt;     // Return false when balance is lower than requested amount.
            return true;
        }
        return false;
    }
}
