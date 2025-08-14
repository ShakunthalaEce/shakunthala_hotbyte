package com.hexaware.hotbyte.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.hexaware.hotbyte.entities.OrderInfo;

@SpringBootTest
class OrderInfoServiceImplTest {
	
	@Autowired
	IOrderInfoService service;

	@Test
	void testGetOrderById() {
		long orderId=2;
		long userId=1;
		OrderInfo info=service.getOrderById(orderId, userId);
		assertEquals(2,info.getOrder_id());
		
		
	}

	@Test
	void testGetOrdersByUser() {
		long id=1;
		List<OrderInfo>orders=service.getOrdersByUser(id);
		assertNotNull(orders);
	}

	@Test
	void testGetAllOrders() {
		List<OrderInfo>allOrders;
		allOrders=service.getAllOrders();
		assertNotNull(allOrders);
	}

}
