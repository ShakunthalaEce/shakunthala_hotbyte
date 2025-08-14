/*
 * Author: Shakunthala
 * Last Modified:13/8/25
 * OrderItem Controller
 * 
 * Responsibility:
 * add,update,delete,get order items
*/

package com.hexaware.hotbyte.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hexaware.hotbyte.entities.OrderItem;
import com.hexaware.hotbyte.service.IOrderItemService;

@RestController
@RequestMapping("/api/orderItem")
public class OrderItemController {
	@Autowired
	IOrderItemService service;

	@GetMapping("/get/{orderItemId}")
	@PreAuthorize("hasAnyRole('USER', 'RESTAURANT_OWNER', 'ADMIN')")
	public OrderItem getOrderItem(@PathVariable Long orderItemId) {
		return service.getOrderItem(orderItemId);
	}

	@GetMapping("/order/{orderId}")
	@PreAuthorize("hasAnyRole('USER', 'RESTAURANT_OWNER', 'ADMIN')")
	public List<OrderItem> getOrderItemsByOrder(@PathVariable Long orderId) {
		return service.getOrderItemsByOrder(orderId);
	}
}
