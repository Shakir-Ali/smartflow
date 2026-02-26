package com.smartflow.orderservice.controller;

import com.smartflow.orderservice.dto.CreateOrderRequest;
import com.smartflow.orderservice.dto.OrderResponse;
import com.smartflow.orderservice.entity.Order;
import com.smartflow.orderservice.service.OrderService;
import com.smartflow.orderservice.util.ApiResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/orders")
@RequiredArgsConstructor
public class OrderController {

    private final OrderService orderService;

    @GetMapping
    public ApiResponse<Page<OrderResponse>> getOrders(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "5") int size
    ) {
        return ApiResponse.<Page<OrderResponse>>builder()
                .success(true)
                .message("Order fetched Successfully")
                .data(orderService.getOrders(page, size))
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

    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("/{id}")
    public ApiResponse<String> deleteOrder(@PathVariable Long id) {
        orderService.deleteOrder(id);
        return ApiResponse.<String>builder()
                .success(true)
                .message("Order Deleted Successfully")
                .data(null)
                .build();
    }
}
