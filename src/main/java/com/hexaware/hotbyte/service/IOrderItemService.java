package com.hexaware.hotbyte.service;

import java.util.List;

import com.hexaware.hotbyte.entities.OrderItem;

public interface IOrderItemService {
	OrderItem getOrderItem(Long orderItemId);                      
    List<OrderItem> getOrderItemsByOrder(Long orderId); 
}
