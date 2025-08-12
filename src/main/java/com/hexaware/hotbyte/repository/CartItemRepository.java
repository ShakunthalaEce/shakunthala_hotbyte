package com.hexaware.hotbyte.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hexaware.hotbyte.entities.Cart;
import com.hexaware.hotbyte.entities.CartItem;
import com.hexaware.hotbyte.entities.MenuItem;

public interface CartItemRepository extends JpaRepository<CartItem,Long>{
	 Optional<CartItem> findByCartAndMenuItem(Cart cart, MenuItem menuItem);
	 List<CartItem> findByCart(Cart cart);
}
