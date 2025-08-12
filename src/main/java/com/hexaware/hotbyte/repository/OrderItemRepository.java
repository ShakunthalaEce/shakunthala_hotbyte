package com.hexaware.hotbyte.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hexaware.hotbyte.entities.OrderItem;

public interface OrderItemRepository extends JpaRepository<OrderItem,Long> {
	List<OrderItem> findByOrderOrderId(Long orderId);
}
