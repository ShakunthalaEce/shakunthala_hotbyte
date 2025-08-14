/*
 * Author: Shakunthala
 * Last Modified:13/8/25
 * Cart Controller
 * 
 * Responsibility:
 * add,update,delete,get cart
*/

package com.hexaware.hotbyte.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hexaware.hotbyte.entities.Cart;
import com.hexaware.hotbyte.service.ICartService;

@RestController
@RequestMapping("/api/cart")
public class CartController {
	@Autowired
	ICartService service;

	@GetMapping("/user/{userId}")
	@PreAuthorize("hasAnyRole('USER', 'ADMIN')")
	public Cart getCartByUser(@PathVariable long userId) {
		return service.getCartByUser(userId);
	}

	@PostMapping("/add/{userId}/{menuItemId}/{quantity}")
	@PreAuthorize("hasAnyRole('USER', 'ADMIN')")
	public Cart addItemToCart(@PathVariable long userId, @PathVariable long menuItemId, @PathVariable long quantity) {
		return service.addItemToCart(userId, menuItemId, quantity);
	}

	@PutMapping("/update/{userId}/{cartItemId}/{quantity}")
	@PreAuthorize("hasAnyRole('USER', 'ADMIN')")
	public Cart updateCartItem(@PathVariable long userId, @PathVariable long cartItemId, @PathVariable long quantity) {
		return service.updateCartItem(userId, cartItemId, quantity);
	}

	@DeleteMapping("/remove/{userId}/{cartItemId}")
	@PreAuthorize("hasAnyRole('USER', 'ADMIN')")
	public void removeItemFromCart(@PathVariable long userId, @PathVariable long cartItemId) {
		service.removeItemFromCart(userId, cartItemId);
	}

	@DeleteMapping("/clear/{userId}")
	@PreAuthorize("hasAnyRole('USER', 'ADMIN')")
	public void clearCart(@PathVariable long userId) {
		service.clearCart(userId);
	}
}
