package com.smartflow.orderservice.repository;

import com.smartflow.orderservice.entity.Order;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface OrderRepository extends JpaRepository<Order, Long> {

    Page<Order> findByTenantId(UUID tenantID, Pageable pageable);

    Optional<Order> findByIdAndTenantId(Long id, UUID tenantId);


}
