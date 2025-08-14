/*
 * Author: Shakunthala
 * Last Modified:13/8/25
 * Restaurant Service
 * 
 * Responsibility:
 * add,update,delete,get restaurant
*/
package com.hexaware.hotbyte.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hexaware.hotbyte.dto.RestaurantDto;
import com.hexaware.hotbyte.entities.Category;
import com.hexaware.hotbyte.entities.Restaurant;
import com.hexaware.hotbyte.entities.UserInfo;
import com.hexaware.hotbyte.exception.ResourceNotFoundException;
import com.hexaware.hotbyte.repository.CategoryRepository;
import com.hexaware.hotbyte.repository.RestaurantRepository;
import com.hexaware.hotbyte.repository.UserInfoRepository;

@Service
public class RestaurantServiceImpl implements IRestaurantService {
	
	@Autowired
	RestaurantRepository restaurantRepo;
	
	@Autowired
	UserInfoRepository userInfoRepo;
	
	@Autowired
	CategoryRepository categoryRepo;

	@Override
	public Restaurant createRestaurant(RestaurantDto restaurantDto) {
		 Restaurant restaurant = new Restaurant();
		    
		    restaurant.setRestaurant_name(restaurantDto.getRestaurant_name());
		    restaurant.setPhone_number(restaurantDto.getPhone_number());
		    restaurant.setCity(restaurantDto.getCity());
		    restaurant.setState(restaurantDto.getState());
		    restaurant.setPincode(restaurantDto.getPincode());
		    if (restaurantDto.getCategoryIds() != null && !restaurantDto.getCategoryIds().isEmpty()) {
		        List<Category> categories = categoryRepo.findAllById(restaurantDto.getCategoryIds());
		        restaurant.setCategories(categories);
		    }
		    
		   
		    UserInfo user = userInfoRepo.findById(restaurantDto.getUserId())
		                    .orElseThrow(() -> new ResourceNotFoundException("User not found with id: " + restaurantDto.getUserId()));
		    restaurant.setUser(user);
		    
		   
		    return restaurantRepo.save(restaurant);
	}

	@Override
	public Restaurant updateRestaurant(Long restaurantId, RestaurantDto restaurantDto) {
		 Restaurant restaurant = restaurantRepo.findById(restaurantId)
		            .orElseThrow(() -> new ResourceNotFoundException("Restaurant not found with id: " + restaurantId));

		    restaurant.setRestaurant_name(restaurantDto.getRestaurant_name());
		    restaurant.setPhone_number(restaurantDto.getPhone_number());
		    restaurant.setCity(restaurantDto.getCity());
		    restaurant.setState(restaurantDto.getState());
		    restaurant.setPincode(restaurantDto.getPincode());
		    
		    if (restaurantDto.getUserId() != null) {
		        UserInfo user = userInfoRepo.findById(restaurantDto.getUserId())
		                .orElseThrow(() -> new ResourceNotFoundException("User not found with id: " + restaurantDto.getUserId()));
		        restaurant.setUser(user);
		    }
		    
		    if (restaurantDto.getCategoryIds() != null && !restaurantDto.getCategoryIds().isEmpty()) {
		        List<Category> categories = categoryRepo.findAllById(restaurantDto.getCategoryIds());
		        restaurant.setCategories(categories);
		    } 

		    return restaurantRepo.save(restaurant);
	}

	@Override
	public void deleteRestaurant(Long restaurantId) {
		 restaurantRepo.deleteById(restaurantId);
		
	}

	@Override
	public Restaurant getRestaurantById(Long restaurantId) {
		 return restaurantRepo.findById(restaurantId)
			        .orElseThrow(() -> new ResourceNotFoundException("Restaurant not found with id: " + restaurantId));
	}

	@Override
	public List<Restaurant> getAllRestaurants() {
		return restaurantRepo.findAll();
	}

	
}
