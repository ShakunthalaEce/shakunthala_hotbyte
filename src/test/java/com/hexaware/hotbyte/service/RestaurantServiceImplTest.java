package com.hexaware.hotbyte.service;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.hexaware.hotbyte.entities.Restaurant;

@SpringBootTest
class RestaurantServiceImplTest {
	
	@Autowired
	IRestaurantService service;

	@Test
	void testGetRestaurantById() {
		long id=1;
		Restaurant res=service.getRestaurantById(id);
		assertEquals(id,res.getRestaurant_id());
	}

	@Test
	void testGetAllRestaurants() {
		List<Restaurant>restaurants;
		restaurants=service.getAllRestaurants();
		assertNotNull(restaurants);
	}

}
