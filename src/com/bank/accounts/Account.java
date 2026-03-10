package com.bank.accounts;

import java.io.FileWriter;
import java.io.PrintWriter;
import java.io.IOException;

public class Account {
    protected String accountNumber;
    protected double balance;

    public Account(String accountNumber, double balance) {
        this.accountNumber = accountNumber;
        this.balance = balance;
    }

    public void deposit(double amount) {
        balance += amount;
        saveTransaction("Deposited: " + amount);
    }

    public void withdraw(double amount) {
        balance -= amount;
        saveTransaction("Withdrew: " + amount);
    }
    public double getBalance() {
        return balance;
    }
    protected void saveTransaction(String message) {
        try (FileWriter fw = new FileWriter("transactions.txt", true);
             PrintWriter pw = new PrintWriter(fw)) {
            pw.println(message + " | Account: " + accountNumber);
        } catch (IOException e) {
            System.out.println("Error writing transaction: " + e.getMessage());
        }
    }
}
