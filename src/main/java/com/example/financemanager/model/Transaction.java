package com.example.financemanager.model;
import java.math.BigDecimal;
import java.time.LocalDate;

public class Transaction {
    private Long id;
    private BigDecimal amount;
    private String type;
    private LocalDate date;
    private String description;
}
