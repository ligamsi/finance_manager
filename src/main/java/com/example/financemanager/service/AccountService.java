package com.example.financemanager.service;

import com.example.financemanager.repository.AccountRepository;
import com.example.financemanager.repository.UserRepository;
import org.springframework.stereotype.Service;
import com.example.financemanager.dto.CreateAccountRequest;
import com.example.financemanager.dto.AccountResponse;
import com.example.financemanager.model.Account;
import com.example.financemanager.model.User;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

@Service
public class AccountService {

    private final AccountRepository accountRepository;
    private final UserRepository userRepository;

    public AccountService(
            AccountRepository accountRepository,
            UserRepository userRepository
    ) {
        this.accountRepository = accountRepository;
        this.userRepository = userRepository;
    }

    @Transactional
    public AccountResponse createAccount(
            Long userId,
            CreateAccountRequest request
    ) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new ResponseStatusException(
                        HttpStatus.NOT_FOUND,
                        "Пользователь не найден"
                ));

        Account account = new Account(
                request.name(),
                request.balance()
        );

        user.addAccount(account);

        Account savedAccount = accountRepository.save(account);

        return new AccountResponse(
                savedAccount.getId(),
                savedAccount.getName(),
                savedAccount.getBalance(),
                user.getId()
        );
    }
}