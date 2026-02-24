package com.smartflow.orderservice.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class CreateOrderRequest {

    @NotBlank
    private String productName;

    @NotNull
    private Double amount;
}
