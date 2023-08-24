package konto;

import java.time.LocalDate;

public class Account {
    private int id = 0;
    private double balance = 0;

    private double annualInterestRate = 0;

    private LocalDate dateCreated;

    public Account(int id, double balance, double annualInterestRate, LocalDate dateCreated) {
        this.id = id;
        this.balance = balance;
        this.annualInterestRate = annualInterestRate;
        this.dateCreated = dateCreated;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public double getAnnualInterestRate() {
        return annualInterestRate;
    }

    public void setAnnualInterestRate(double annualInterestRate) {
        this.annualInterestRate = annualInterestRate;
    }

    public LocalDate getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(LocalDate dateCreated) {
        this.dateCreated = dateCreated;
    }

    public double getMonthlyInterestRate(double annualInterestRate){
        double monthlyInterestRate = 0;
        monthlyInterestRate = annualInterestRate / 12;
        return monthlyInterestRate;
    }

    public double monthlyInterest(double monthlyInterestRate){
        double monthlyInterest = 0;
        monthlyInterest = balance * monthlyInterestRate;
        return monthlyInterest;
    }

    public double withdraw (double balance){
        double hæve = 0;
        balance = balance - hæve;
        return balance;
    }

    public double deposit(double balance){
        double indsæt = 0;
        balance += balance + indsæt;
        return balance;
    }

    @Override
    public String toString() {
        return "Account{" +
                "id=" + id +
                ", balance=" + balance +
                ", annualInterestRate=" + annualInterestRate +
                ", dateCreated=" + dateCreated +
                '}';
    }
}