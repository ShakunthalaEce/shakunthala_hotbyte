/*
 * Author: Shakunthala
 * Last Modified:13/8/25
 * Restaurant Controller
 * 
 * Responsibility:
 * add,update,delete,get restaurant
*/

package com.hexaware.hotbyte.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hexaware.hotbyte.dto.RestaurantDto;
import com.hexaware.hotbyte.entities.Restaurant;
import com.hexaware.hotbyte.service.IRestaurantService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/restaurant")
public class RestaurantController {
	@Autowired
	IRestaurantService service;

	@PostMapping("/create")
	@PreAuthorize("hasAnyRole('ADMIN','RESTAURANT_OWNER')")
	public Restaurant createRestaurant(@RequestBody @Valid RestaurantDto restaurantDto) {
		return service.createRestaurant(restaurantDto);
	}

	@PutMapping("/update/{restaurantId}")
	@PreAuthorize("hasAnyRole('RESTAURANT_OWNER', 'ADMIN')")
	public Restaurant updateRestaurant(@PathVariable Long restaurantId, @RequestBody RestaurantDto restaurantDto) {
		return service.updateRestaurant(restaurantId, restaurantDto);
	}

	@DeleteMapping("/delete/{restaurantId}")
	@PreAuthorize("hasRole('ADMIN')")
	public void deleteRestaurant(@PathVariable Long restaurantId) {
		service.deleteRestaurant(restaurantId);
	}

	@GetMapping("/get/{restaurantId}")
	@PreAuthorize("hasAnyRole('USER', 'RESTAURANT_OWNER', 'ADMIN')")
	public Restaurant getRestaurantById(@PathVariable Long restaurantId) {
		return service.getRestaurantById(restaurantId);
	}

	@GetMapping("/all")
	@PreAuthorize("hasAnyRole('USER', 'RESTAURANT_OWNER', 'ADMIN')")
	public List<Restaurant> getAllRestaurants() {
		return service.getAllRestaurants();
	}
}
