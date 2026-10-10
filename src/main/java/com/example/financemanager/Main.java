package com.example.financemanager;

import com.example.financemanager.model.Transaction;
import com.example.financemanager.model.TransactionType;
import com.example.financemanager.model.Account;
import com.example.financemanager.model.User;
import com.example.financemanager.model.Category;

import java.math.BigDecimal;
import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        User user = new User("Иван", "ivan@mail.ru");

        Category category = new Category("Продукты");

        Account account = new Account(
                "Основная карта",
                new BigDecimal("150000")
        );

        user.addAccount(account);

        Transaction expense = new Transaction(
                new BigDecimal("8500"),
                TransactionType.EXPENSE,
                LocalDate.of(2026, 10, 1),
                "Продукты",
                category
        );

        account.addTransaction(expense);

        System.out.println(user.getAccounts().size());
        System.out.println(account.getTransactions().size());
        System.out.println(expense.getCategory().getName());
    }
}
