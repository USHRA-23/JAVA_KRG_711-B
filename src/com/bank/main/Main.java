package com.bank.main;

import com.bank.accounts.SavingsAccount;
import com.bank.exceptions.InsufficientBalanceException;

public class Main {
    public static void main(String[] args) {
        SavingsAccount sa = new SavingsAccount("ACC123", 5000);
        sa.deposit(2000);
        System.out.println("Balance after deposit: " + sa.getBalance());
        try {
            sa.withdraw(8000); // should throw exception
        } catch (InsufficientBalanceException e) {
            System.out.println(e.getMessage());
        }
        try {
            sa.withdraw(3000);
            System.out.println("Balance after withdrawal: " + sa.getBalance());
        } catch (InsufficientBalanceException e) {
            System.out.println(e.getMessage());
        }
    }
}
