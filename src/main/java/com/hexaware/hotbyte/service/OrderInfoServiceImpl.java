/*
 * Author: Shakunthala
 * Last Modified:13/8/25
 * Order Info Service
 * 
 * Responsibility:
 * add,update,delete,get order
*/
package com.hexaware.hotbyte.service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hexaware.hotbyte.dto.OrderInfoDto;
import com.hexaware.hotbyte.entities.Address;
import com.hexaware.hotbyte.entities.Cart;
import com.hexaware.hotbyte.entities.CartItem;
import com.hexaware.hotbyte.entities.OrderInfo;
import com.hexaware.hotbyte.entities.OrderItem;
import com.hexaware.hotbyte.entities.Restaurant;
import com.hexaware.hotbyte.entities.UserInfo;
import com.hexaware.hotbyte.enums.OrderStatus;
import com.hexaware.hotbyte.exception.ResourceNotFoundException;
import com.hexaware.hotbyte.repository.AddressRepository;
import com.hexaware.hotbyte.repository.OrderInfoRepository;
import com.hexaware.hotbyte.repository.OrderItemRepository;
import com.hexaware.hotbyte.repository.RestaurantRepository;
import com.hexaware.hotbyte.repository.UserInfoRepository;

@Service
public class OrderInfoServiceImpl implements IOrderInfoService {

	@Autowired
	OrderInfoRepository orderInfoRepo;

	@Autowired
	RestaurantRepository restaurantRepo;

	@Autowired
	AddressRepository addressRepo;

	@Autowired
	UserInfoRepository userInfoRepo;

	@Autowired
	ICartService cartService;

	@Autowired
	OrderItemRepository orderItemRepo;

	@Override
	public OrderInfo placeOrder(long userId, OrderInfoDto orderInfoDto) {

		
		UserInfo user = userInfoRepo.findById(userId)
				.orElseThrow(() -> new ResourceNotFoundException("User not found with id: " + userId));
		Restaurant restaurant = restaurantRepo.findById(orderInfoDto.getRestaurant_id())
				.orElseThrow(() -> new ResourceNotFoundException(
						"Restaurant not found with id: " + orderInfoDto.getRestaurant_id()));
		Address shippingAddress = addressRepo.findById(orderInfoDto.getShipping_address_id())
				.orElseThrow(() -> new ResourceNotFoundException(
						"Shipping address not found with id: " + orderInfoDto.getShipping_address_id()));

		
		Cart cart = cartService.getCartByUser(userId);
		if (cart.getCartItems().isEmpty()) {
			throw new IllegalStateException("Cannot place an order with an empty cart.");
		}

		
		OrderInfo order = new OrderInfo();
		order.setUser(user);
		order.setRestaurant(restaurant);
		order.setShippingAddress(shippingAddress);
//		order.setOrder_time(orderInfoDto.getOrder_time());
		order.setOrder_time(LocalDateTime.now());
		order.setStatus(OrderStatus.valueOf(orderInfoDto.getStatus()));

		
		double calculatedTotalAmount = 0.0;
		List<OrderItem> orderItems = new ArrayList<>();
		for (CartItem cartItem : cart.getCartItems()) {
			OrderItem orderItem = new OrderItem();
			orderItem.setOrder(order); 
			orderItem.setMenuItem(cartItem.getMenuItem());
			orderItem.setQuantity(cartItem.getQuantity());

			
			double itemPrice = cartItem.getMenuItem().getPrice() * cartItem.getQuantity();
			orderItem.setPrice(itemPrice);

			
			calculatedTotalAmount += itemPrice;

			orderItems.add(orderItem);
		}

		
		order.setOrderItem(orderItems);
		order.setTotal_amount(calculatedTotalAmount); 
		
		OrderInfo savedOrder = orderInfoRepo.save(order);
		return savedOrder;

	}

	@Override
	public OrderInfo getOrderById(Long orderId, long userId) {
		OrderInfo order = orderInfoRepo.findById(orderId)
				.orElseThrow(() -> new ResourceNotFoundException("Order not found with id: " + orderId));
		return order;
	}

	@Override
	public List<OrderInfo> getOrdersByUser(long userId) {
		return orderInfoRepo.findOrdersByUserId(userId);
	}

	@Override
	public List<OrderInfo> getAllOrders() {
		return orderInfoRepo.findAll();
	}

	@Override
	public void updateOrderStatus(long orderId, OrderStatus status) {
		OrderInfo order = orderInfoRepo.findById(orderId)
				.orElseThrow(() -> new ResourceNotFoundException("Order not found with id: " + orderId));

		order.setStatus(status);
		orderInfoRepo.save(order);

	}

}
