package com.example.financemanager.dto;

public record CreateUserRequest(
        String name,
        String email
) {
}
