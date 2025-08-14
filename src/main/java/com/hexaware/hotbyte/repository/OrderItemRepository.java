package com.hexaware.hotbyte.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.hexaware.hotbyte.entities.OrderItem;

public interface OrderItemRepository extends JpaRepository<OrderItem,Long> {
	 @Query("SELECT oi FROM OrderItem oi WHERE oi.order.order_id = :orderId")
	    List<OrderItem> findOrderItemsByOrderId(@Param("orderId") Long orderId);
}
