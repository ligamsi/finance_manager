package com.example.financemanager.dto;

import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;

public record CreateAccountRequest(

        @NotBlank(message = "Название счёта не должно быть пустым")
        String name,

        @NotNull(message = "Начальный баланс обязателен")
        @DecimalMin(value = "0.00", message = "Начальный баланс не может быть отрицательным")
        BigDecimal balance

) {
}