package com.hexaware.hotbyte.service;

import java.util.List;

import com.hexaware.hotbyte.entities.Restaurant;

public interface IRestaurantService {
	public int addRestaurant(Restaurant res);
	public int updateRestaurant(Restaurant res);
	public List<Restaurant> getAllRestaurant();
	public Restaurant getRestaurantById(int id);
}
