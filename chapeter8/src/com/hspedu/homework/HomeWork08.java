package com.hspedu.homework;

public class HomeWork08 {
    public static void main(String[] args) {
//        CheckingAccount checkingAccount = new CheckingAccount(1000);
//        System.out.println(checkingAccount.getBalance());
//        checkingAccount.deposit(10);
//        System.out.println(checkingAccount.getBalance());
//        checkingAccount.withdraw(5);
//        System.out.println(checkingAccount.getBalance());
        SavingsAccount savingsAccount = new SavingsAccount(1000);
        System.out.println(savingsAccount.getBalance());
        savingsAccount.deposit(1000);
        System.out.println(savingsAccount.getBalance());
        savingsAccount.withdraw(1000);
        System.out.println(savingsAccount.getBalance());
        savingsAccount.deposit(5000);
        System.out.println(savingsAccount.getBalance());
        savingsAccount.withdraw(2000);
        System.out.println(savingsAccount.getBalance());
        savingsAccount.earnMonthlyInterest();
        System.out.println(savingsAccount.getBalance());

    }
}

class BankAccount {
    private double balance;

    public BankAccount(double balance) {
        this.balance = balance;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public void deposit(double amount) {
        balance += amount;
    }

    public void withdraw(double amount) {
        balance -= amount;
    }
}

class CheckingAccount extends BankAccount {
    double fee = 1;

    public CheckingAccount(double balance) {
        super(balance);
    }

    public double getFee() {
        return fee;
    }

    public void setFee(double fee) {
        this.fee = fee;
    }

    public void Fee() {
        super.withdraw(getFee());
    }

    @Override
    public void deposit(double amount) {
        super.deposit(amount);
        Fee();
    }

    @Override
    public void withdraw(double amount) {
        super.withdraw(amount);
        Fee();
    }
}

class SavingsAccount extends BankAccount {
    private double interestRate = 0.03;
    private int freeCount = 3;
    private double fee = 1;

    public double getFee() {
        return fee;
    }

    public void setFee(double fee) {
        this.fee = fee;
    }

    public SavingsAccount(double balance) {
        super(balance);
    }

    public double getInterestRate() {
        return interestRate;
    }

    public void setInterestRate(double interestRate) {
        this.interestRate = interestRate;
    }

    public int getFreeCount() {
        return freeCount;
    }

    public void setFreeCount(int freeCount) {
        this.freeCount = freeCount;
    }

    public void earnMonthlyInterest() {
        super.deposit(getBalance() * interestRate);
        resetFreeCount();
    }

    public void resetFreeCount() {
        freeCount = 3;
    }

    public void Fee() {
        super.withdraw(getFee());
    }

    public void checkFreeCount() {
        if (freeCount == 0) {
            Fee();
        } else freeCount--;
    }

    @Override
    public void deposit(double amount) {
        super.deposit(amount);
        checkFreeCount();
    }

    @Override
    public void withdraw(double amount) {
        super.withdraw(amount);
        checkFreeCount();
    }
}