package com.smartflow.orderservice.dto;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Builder
public class OrderResponse {

    private Long id;
    private String productName;
    private Double amount;
    private LocalDateTime createdAt;
}
