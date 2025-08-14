/*
 * Author: Shakunthala
 * Last Modified:13/8/25
 * Cart Item Service
 * 
 * Responsibility:
 * add,update,delete,get cart items
*/
package com.hexaware.hotbyte.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hexaware.hotbyte.dto.CartItemDto;
import com.hexaware.hotbyte.entities.Cart;
import com.hexaware.hotbyte.entities.CartItem;
import com.hexaware.hotbyte.entities.MenuItem;
import com.hexaware.hotbyte.exception.ResourceNotFoundException;
import com.hexaware.hotbyte.repository.CartItemRepository;
import com.hexaware.hotbyte.repository.CartRepository;
import com.hexaware.hotbyte.repository.MenuItemRepository;

@Service
public class CartItemServiceImpl implements ICartItemService {

	@Autowired
	CartItemRepository repo;

	@Autowired
	MenuItemRepository menuItemRepo;

	@Autowired
	CartRepository cartRepo;

	@Override
	public CartItem addCartItem(CartItemDto cartItemDto) {
		MenuItem menuItem = menuItemRepo.findById(cartItemDto.getMenu_item_id()).orElseThrow(
				() -> new ResourceNotFoundException("MenuItem not found with id: " + cartItemDto.getMenu_item_id()));

		Cart cart = cartRepo.findById(cartItemDto.getCart_id()).orElseThrow(
				() -> new ResourceNotFoundException("Cart not found with id: " + cartItemDto.getCart_id()));
		CartItem cartItem = new CartItem();

		cartItem.setCart(cart);
		cartItem.setMenuItem(menuItem);
		cartItem.setQuantity(cartItemDto.getQuantity());

		return repo.save(cartItem);
	}

	@Override
	public List<CartItem> getCartItem() {
		return repo.findAll();
	}

}
