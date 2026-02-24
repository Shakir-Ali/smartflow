package com.smartflow.orderservice.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "Orders")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private UUID tenantId;

    @Column(nullable = false)
    private String productName;

    @Column(nullable = false)
    private Double amount;

    @Column(nullable = false)
    private LocalDateTime createdAt;
}
