package com.hexaware.hotbyte.service;

import java.util.List;

import com.hexaware.hotbyte.dto.CartItemDto;
import com.hexaware.hotbyte.entities.CartItem;

public interface ICartItemService {
	public CartItem addCartItem(CartItemDto cartItemDto);
	public List<CartItem> getCartItem();
}
