package com.smartflow.orderservice.service;

import com.smartflow.orderservice.dto.CreateOrderRequest;
import com.smartflow.orderservice.dto.OrderResponse;
import com.smartflow.orderservice.entity.Order;
import com.smartflow.orderservice.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
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
                .build();

        Order saved = orderRepository.save(order);

        return OrderResponse.builder()
                .id(saved.getId())
                .productName(saved.getProductName())
                .amount(saved.getAmount())
                .createdAt(saved.getCreatedAt())
                .build();
    }

    public Page<OrderResponse> getOrders(int page, int size) {
        String tenantIdStr = (String) SecurityContextHolder
                .getContext()
                .getAuthentication()
                .getCredentials();

        UUID tenantId = UUID.fromString(tenantIdStr);

        Pageable pageable = PageRequest.of(page, size, Sort.by("CreatedAt").descending());

        Page<Order> orderPage = orderRepository.findByTenantId(tenantId, pageable);

        return orderPage.map(order -> OrderResponse.builder()
                        .id(order.getId())
                        .productName(order.getProductName())
                        .amount(order.getAmount())
                        .createdAt(order.getCreatedAt())
                        .build());
    }

    public void deleteOrder(Long id) {
        Order order = orderRepository.findById(id).orElseThrow(() -> new RuntimeException("Order Not Found"));

        orderRepository.delete(order);
    }
}
