package com.hexaware.hotbyte.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hexaware.hotbyte.entities.CartItem;

public interface CartItemRepository extends JpaRepository<CartItem,Integer>{

}
