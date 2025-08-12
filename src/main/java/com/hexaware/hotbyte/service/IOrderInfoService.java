package com.hexaware.hotbyte.service;

import java.util.List;

import com.hexaware.hotbyte.dto.OrderInfoDto;
import com.hexaware.hotbyte.entities.OrderInfo;
import com.hexaware.hotbyte.enums.OrderStatus;

public interface IOrderInfoService {
	OrderInfo placeOrder(long userId, OrderInfoDto orderInfo); 
    OrderInfo getOrderById(Long orderId, long userId);               
    List<OrderInfo> getOrdersByUser(long userId);                    
    List<OrderInfo> getAllOrders();                                  
    void updateOrderStatus(long orderId, OrderStatus status);  
}
