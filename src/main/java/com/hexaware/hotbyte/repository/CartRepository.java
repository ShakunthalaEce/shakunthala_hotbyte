package com.hexaware.hotbyte.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hexaware.hotbyte.entities.Cart;

public interface CartRepository extends JpaRepository<Cart,Long>{
	Optional<Cart> findByUserUserId(long userId);
}
