package com.example.financemanager;
import java.math.BigDecimal;
import java.time.LocalDate;

import com.example.financemanager.model.Transaction;
import com.example.financemanager.model.TransactionType;

public class Main {
    public static void main(String[] args) {
        Transaction expense = new Transaction(
                new BigDecimal("8500"),
                TransactionType.EXPENSE,
                LocalDate.of(2026,10,1),
                "Продукты"
        );

        Transaction income = new Transaction(
                new BigDecimal("150000"),
                TransactionType.INCOME,
                LocalDate.of(2026, 10,1),
                "Зарплата"
        );

        System.out.println(expense);
        System.out.println(income);
    }
}
