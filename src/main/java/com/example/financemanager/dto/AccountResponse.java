package com.example.financemanager.dto;

import java.math.BigDecimal;

public record AccountResponse(
        Long id,
        String name,
        BigDecimal balance,
        Long userId
) {
}