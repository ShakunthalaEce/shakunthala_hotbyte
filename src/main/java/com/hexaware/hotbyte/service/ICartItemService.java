package com.hexaware.hotbyte.service;

import java.util.List;

import com.hexaware.hotbyte.entities.CartItem;

public interface ICartItemService {
	public int addCartItem(CartItem cartItem);
	public List<CartItem> getCartItem();
}
