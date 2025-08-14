package com.hexaware.hotbyte.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hexaware.hotbyte.entities.Cart;
import com.hexaware.hotbyte.entities.CartItem;
import com.hexaware.hotbyte.entities.Category;
import com.hexaware.hotbyte.entities.MenuItem;
import com.hexaware.hotbyte.entities.Restaurant;

public interface MenuItemRepository extends JpaRepository<MenuItem, Long> {
	

	List<MenuItem> findByCategory(Category category);

	List<MenuItem> findByRestaurant(Restaurant restaurant);
	
}
