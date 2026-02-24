package com.smartflow.orderservice.repository;

import com.smartflow.orderservice.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface OrderRepository extends JpaRepository<Order, Long> {

    List<Order> findByTenantId(UUID tenantID);
}
