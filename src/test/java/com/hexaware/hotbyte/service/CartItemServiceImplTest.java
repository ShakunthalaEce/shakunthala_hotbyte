package com.hexaware.hotbyte.service;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.hexaware.hotbyte.entities.CartItem;

@SpringBootTest
class CartItemServiceImplTest {
	
	@Autowired
	ICartItemService service;

	@Test
	void testGetCartItem() {
		List<CartItem>items=service.getCartItem();
		assertNotNull(items);
	}

}
