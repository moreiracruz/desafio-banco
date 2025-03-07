package br.com.moreiracruz.contabanco.service;

public class ContaService {

    private String customerName = null;
    private String agency = null;
    private int accountNumber;
    private double balance;

    public ContaService(String customerName, String agency, int accountNumber, double balance) {
        this.customerName = customerName;
        this.agency = agency;
        this.accountNumber = accountNumber;
        this.balance = balance;
    }

    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
        }
    }

    public void withdraw(double amount) {
        if (amount > 0 && balance >= amount) {
            balance -= amount;
        }
    }

    public String createWelcomeMessage() {
        return String.format(
            "Hello %s, thank you for creating an account at our bank, your agency is %s, account %d and your balance %.2f is now available for withdrawal.",
            customerName,
            agency,
            accountNumber,
            balance
        );
    }
    
    public String getCustomerName() {
        return customerName;
    }

    public String getAgency() {
        return agency;
    }

    public double getBalance() {
        return balance;
    }

    public int getAccountNumber() {
        return accountNumber;
    }

}
