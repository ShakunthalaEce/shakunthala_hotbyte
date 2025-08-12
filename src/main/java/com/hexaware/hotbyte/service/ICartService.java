package com.hexaware.hotbyte.service;

import com.hexaware.hotbyte.entities.Cart;

public interface ICartService {
	    Cart getCartByUser(long userId);                             
	    Cart addItemToCart(long userId, long menuItemId, long quantity); 
	    Cart updateCartItem(long userId, long cartItemId, long quantity); 
	    void removeItemFromCart(long userId, long cartItemId);      
	    void clearCart(long userId);                                
}
