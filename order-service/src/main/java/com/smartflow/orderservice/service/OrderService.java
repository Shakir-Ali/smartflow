package com.smartflow.orderservice.service;

import com.smartflow.orderservice.dto.CreateOrderRequest;
import com.smartflow.orderservice.dto.OrderResponse;
import com.smartflow.orderservice.entity.Order;
import com.smartflow.orderservice.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class OrderService {

    private final OrderRepository orderRepository;

    public OrderResponse createOrder(CreateOrderRequest request) {
        String tenantIdStr = (String) SecurityContextHolder
                .getContext()
                .getAuthentication()
                .getCredentials();

        UUID tenantId = UUID.fromString(tenantIdStr);

        Order order = Order.builder()
                .tenantId(tenantId)
                .productName(request.getProductName())
                .amount(request.getAmount())
                .createdAt(LocalDateTime.now())
                .build();

        Order saved = orderRepository.save(order);

        return OrderResponse.builder()
                .id(saved.getId())
                .productName(saved.getProductName())
                .amount(saved.getAmount())
                .createdAt(saved.getCreatedAt())
                .build();
    }

    public List<OrderResponse> getOrders() {
        String tenantIdStr = (String) SecurityContextHolder
                .getContext()
                .getAuthentication()
                .getCredentials();

        UUID tenantId = UUID.fromString(tenantIdStr);

        return orderRepository.findByTenantId(tenantId)
                .stream()
                .map(order -> OrderResponse.builder()
                        .id(order.getId())
                        .productName(order.getProductName())
                        .amount(order.getAmount())
                        .createdAt(order.getCreatedAt())
                        .build())
                .toList();
    }
}
