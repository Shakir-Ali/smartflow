package com.smartflow.orderservice.controller;

import com.smartflow.orderservice.dto.CreateOrderRequest;
import com.smartflow.orderservice.dto.OrderResponse;
import com.smartflow.orderservice.entity.Order;
import com.smartflow.orderservice.service.OrderService;
import com.smartflow.orderservice.util.ApiResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/orders")
@RequiredArgsConstructor
public class OrderController {

    private final OrderService orderService;

    @GetMapping
    public ApiResponse<List<OrderResponse>> getOrders() {
        return ApiResponse.<List<OrderResponse>>builder()
                .success(true)
                .message("Order fetched Successfully")
                .data(orderService.getOrders())
                .build();
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping
    public ApiResponse<OrderResponse> createOrder(@Valid @RequestBody CreateOrderRequest request) {
        return ApiResponse.<OrderResponse>builder()
                .success(true)
                .message("Order Created Successfully")
                .data(orderService.createOrder(request))
                .build();
    }
}
