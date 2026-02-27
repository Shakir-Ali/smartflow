package com.smartflow.orderservice.event;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderCreatedEvent {

    private Long orderId;
    private UUID tenantId;
    private String productName;
    private Double Amount;
    private String createdBy;
    private LocalDateTime createdAt;
}
