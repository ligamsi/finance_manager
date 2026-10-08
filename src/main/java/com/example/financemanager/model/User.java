package com.example.financemanager.model;
import java.util.ArrayList;
import java.util.List;

public class User {
    private Long id;
    private String name;
    private String email;

    private List<Account> accounts = new ArrayList<>();

    public void addAccount(Account account) {
        accounts.add(account);
    }

    public Long getId() {
        return id;
    }
    public String getName() {
        return name;
    }
    public String getEmail() {
        return email;
    }
    public List<Account> getAccounts() {
        return accounts;
    }
}
