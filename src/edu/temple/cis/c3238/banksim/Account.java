package edu.temple.cis.c3238.banksim;

/**
 * @author Cay Horstmann
 * @author Modified by Paul Wolfgang
 * @author Modified by Charles Wang
 */
public class Account {

    private volatile int balance;
    private final int id;
    private final Bank myBank;

    public Account(Bank myBank, int id, int initialBalance) {
        this.myBank = myBank;
        this.id = id;
        balance = initialBalance;
    }

    public int getBalance() {
        return balance;
    }

    public synchronized boolean withdraw(int amount) {
        if (amount <= balance) {
            int currentBalance = balance;
            int newBalance = currentBalance - amount;
            balance = newBalance;
            return true;
        } else {
            return false;
        }
    }

    public synchronized void deposit(int amount) {
        int currentBalance = balance;
        int newBalance = currentBalance + amount;
        balance = newBalance;
        notifyAll();
    }
    
    @Override
    public String toString() {
        return String.format("Account[%d] balance %d", id, balance);
    }
    
    public synchronized void waitForAvailableFunds(int amount) {
        while (myBank.isBankOpen() && amount > balance) {
            try {
                wait();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        while (myBank.isBankOpen() && amount <= balance) {
            try {
                notify();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
