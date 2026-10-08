package com.example.financemanager.model;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class Account {
    private Long id;
    private String name;
    private BigDecimal balance;

    private List<Transaction> transactions = new ArrayList<>();

    public void addTransaction(Transaction transaction) {
        transactions.add(transaction);
    }

    public Account(String name, BigDecimal balance) {
        this.name = name;
        this.balance = balance;
    }

    public String getName() {
        return name;
    }
    public BigDecimal getBalance() {
        return balance;
    }
    public List<Transaction> getTransactions() {
        return transactions;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }
}
