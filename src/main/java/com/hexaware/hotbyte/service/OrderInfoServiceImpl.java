package com.hexaware.hotbyte.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.hexaware.hotbyte.dto.OrderInfoDto;
import com.hexaware.hotbyte.entities.Address;
import com.hexaware.hotbyte.entities.OrderInfo;
import com.hexaware.hotbyte.entities.Restaurant;
import com.hexaware.hotbyte.entities.UserInfo;
import com.hexaware.hotbyte.enums.OrderStatus;
import com.hexaware.hotbyte.exception.ResourceNotFoundException;
import com.hexaware.hotbyte.repository.AddressRepository;
import com.hexaware.hotbyte.repository.OrderInfoRepository;
import com.hexaware.hotbyte.repository.RestaurantRepository;
import com.hexaware.hotbyte.repository.UserInfoRepository;

public class OrderInfoServiceImpl implements IOrderInfoService {

	@Autowired
	OrderInfoRepository orderInfoRepo;

	@Autowired
	RestaurantRepository restaurantRepo;

	@Autowired
	AddressRepository addressRepo;

	@Autowired
	UserInfoRepository userInfoRepo;

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
		OrderInfo order = new OrderInfo();
		order.setUser(user);
		order.setRestaurant(restaurant);
		order.setShippingAddress(shippingAddress);
		order.setTotal_amount(orderInfoDto.getTotal_amount());
		order.setOrder_time(orderInfoDto.getOrder_time());
		order.setStatus(OrderStatus.valueOf(orderInfoDto.getStatus()));

		return orderInfoRepo.save(order);
	}

	@Override
	public OrderInfo getOrderById(Long orderId, long userId) {
		OrderInfo order = orderInfoRepo.findById(orderId)
				.orElseThrow(() -> new ResourceNotFoundException("Order not found with id: " + orderId));
		return order;
	}

	@Override
	public List<OrderInfo> getOrdersByUser(long userId) {
		return orderInfoRepo.findByUserUserId(userId);
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
