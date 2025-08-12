package com.hexaware.hotbyte.service;

import java.util.List;

import com.hexaware.hotbyte.dto.RestaurantDto;
import com.hexaware.hotbyte.entities.Restaurant;

public interface IRestaurantService {
	Restaurant createRestaurant(RestaurantDto restaurantDto);

	Restaurant updateRestaurant(Long restaurantId, RestaurantDto restaurantDto);

	void deleteRestaurant(Long restaurantId);

	Restaurant getRestaurantById(Long restaurantId);

	List<Restaurant> getAllRestaurants();
}
