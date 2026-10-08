package com.example.financemanager.model;

public class Category {
    private Long id;
    private String name;

    public Category(String name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }
    public String getName() {
        return name;
    }
}
