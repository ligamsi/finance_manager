package com.example.financemanager.controller;

import com.example.financemanager.dto.AccountResponse;
import com.example.financemanager.dto.CreateAccountRequest;
import com.example.financemanager.service.AccountService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/users/{userId}/accounts")
public class AccountController {

    private final AccountService accountService;

    public AccountController(AccountService accountService) {
        this.accountService = accountService;
    }

    @PostMapping
    public AccountResponse createAccount(
            @PathVariable Long userId,
            @Valid @RequestBody CreateAccountRequest request
    ) {
        return accountService.createAccount(userId, request);
    }
}