/*
 * Author: Shakunthala
 * Last Modified:13/8/25
 * Order Item Service
 * 
 * Responsibility:
 * get order items
*/
package com.hexaware.hotbyte.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hexaware.hotbyte.entities.OrderItem;
import com.hexaware.hotbyte.exception.ResourceNotFoundException;
import com.hexaware.hotbyte.repository.OrderItemRepository;

@Service
public class OrderItemServiceImpl implements IOrderItemService{
	
	@Autowired
	OrderItemRepository orderItemRepo;

	@Override
	public OrderItem getOrderItem(Long orderItemId) {
		return orderItemRepo.findById(orderItemId).orElseThrow(() -> new ResourceNotFoundException("Order not found with id: " + orderItemId));
	}

	@Override
	public List<OrderItem> getOrderItemsByOrder(Long orderId) {
		 return orderItemRepo.findOrderItemsByOrderId(orderId);
	}

}
