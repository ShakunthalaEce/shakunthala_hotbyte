/*
 * Author: Shakunthala
 * Last Modified:13/8/25
 * CartItem Controller
 * 
 * Responsibility:
 * add,update,delete,get cartItems
*/

package com.hexaware.hotbyte.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hexaware.hotbyte.dto.CartItemDto;
import com.hexaware.hotbyte.entities.CartItem;
import com.hexaware.hotbyte.service.ICartItemService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/cartItem")
public class CartItemController {
	@Autowired
	ICartItemService service;

	
	@PostMapping("/add")
	@PreAuthorize("hasAnyRole('USER', 'ADMIN')")
	public CartItem addCartItem(@RequestBody @Valid CartItemDto cartItemDto) {
		return service.addCartItem(cartItemDto);
	}
	
	
	@GetMapping("/all")
	@PreAuthorize("hasRole('ADMIN')")
	public List<CartItem> getCartItem() {
		return service.getCartItem();
	}
}
