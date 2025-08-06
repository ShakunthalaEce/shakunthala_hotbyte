package com.hexaware.hotbyte.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hexaware.hotbyte.entities.OrderItem;

public interface OrderItemRepository extends JpaRepository<OrderItem,Integer> {

}
