/*
 * Author: Shakunthala
 * Last Modified:13/8/25
 * Order Controller
 * 
 * Responsibility:
 * add,update,delete,get orders
*/

package com.hexaware.hotbyte.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hexaware.hotbyte.dto.OrderInfoDto;
import com.hexaware.hotbyte.entities.OrderInfo;
import com.hexaware.hotbyte.enums.OrderStatus;
import com.hexaware.hotbyte.service.IOrderInfoService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/orderInfo")
public class OrderInfoController {
	@Autowired
	IOrderInfoService service;

	
	@PostMapping("/place/{userId}")
	@PreAuthorize("hasAnyRole('USER', 'ADMIN')")
	public OrderInfo placeOrder(@PathVariable long userId, @RequestBody @Valid OrderInfoDto orderInfoDto) {
		return service.placeOrder(userId, orderInfoDto);
	}

	@GetMapping("/get/{orderId}/{userId}")
	@PreAuthorize("hasAnyRole('USER', 'ADMIN')")
	public OrderInfo getOrderById(@PathVariable Long orderId, @PathVariable long userId) {
		return service.getOrderById(orderId, userId);
	}

	@GetMapping("/user/{userId}")
	@PreAuthorize("hasAnyRole('USER', 'ADMIN')")
	public List<OrderInfo> getOrdersByUser(@PathVariable long userId) {
		return service.getOrdersByUser(userId);
	}

	@GetMapping("/all")
	@PreAuthorize("hasRole('ADMIN')")
	public List<OrderInfo> getAllOrders() {
		return service.getAllOrders();
	}

	@PutMapping("/status/{orderId}/{status}")
	@PreAuthorize("hasAnyRole('RESTAURANT_OWNER', 'ADMIN')")
	public void updateOrderStatus(@PathVariable long orderId, @PathVariable OrderStatus status) {
		service.updateOrderStatus(orderId, status);
	}
}
