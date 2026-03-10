package com.bank.accounts;

import com.bank.exceptions.InsufficientBalanceException;

public class SavingsAccount extends Account {

    public SavingsAccount(String accountNumber, double balance) {
        super(accountNumber, balance);
    }

    @Override
    public void withdraw(double amount) throws InsufficientBalanceException {
        if (amount > balance) {
            throw new InsufficientBalanceException("Insufficient balance for withdrawal!");
        }
        super.withdraw(amount);
    }
}
