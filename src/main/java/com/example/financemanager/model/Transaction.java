package com.example.financemanager.model;
import java.math.BigDecimal;
import java.time.LocalDate;

public class Transaction {
    private Long id;
    private BigDecimal amount;
    private TransactionType type;
    private LocalDate date;
    private String description;
    private Category category;

    public Transaction(BigDecimal amount, TransactionType type,
                       LocalDate date, String description, Category category) {
        this.amount = amount;
        this.type = type;
        this.date = date;
        this.description = description;
        this.category = category;
    }

    public BigDecimal getAmount() {
        return amount;
    }
    public TransactionType getType() {
        return type;
    }
    public LocalDate getDate() {
        return date;
    }
    public String getDescription() {
        return description;
    }
    public Category getCategory() {
        return category;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }
    public void setType(TransactionType type) {
        this.type = type;
    }
    public void setDate(LocalDate date) {
        this.date = date;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public void setCategory(Category category) {
        this.category = category;
    }

    @Override
    public String toString() {
        return "Transaction{" +
                "amount=" + amount +
                ", type=" + type +
                ", date=" + date +
                ", description='" + description + '\'' +
                '}';
    }
}
