package com.hexaware.hotbyte.service;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hexaware.hotbyte.entities.Cart;
import com.hexaware.hotbyte.entities.CartItem;
import com.hexaware.hotbyte.entities.MenuItem;
import com.hexaware.hotbyte.entities.UserInfo;
import com.hexaware.hotbyte.exception.ResourceNotFoundException;
import com.hexaware.hotbyte.repository.CartItemRepository;
import com.hexaware.hotbyte.repository.CartRepository;
import com.hexaware.hotbyte.repository.MenuItemRepository;
import com.hexaware.hotbyte.repository.UserInfoRepository;

@Service
public class CartServiceImpl implements ICartService {
	
	@Autowired
	CartRepository cart_repo;

	@Autowired
	MenuItemRepository menu_item_repo;
	
	@Autowired
	CartItemRepository cart_item_repo;
	
	@Autowired
	UserInfoRepository user_info_repo;
	
	@Override
	public Cart getCartByUser(long userId) {
	    return cart_repo.findByUserUserId(userId)
	    		.orElseThrow(() -> new ResourceNotFoundException("Cart not found for user with id: " + userId));

	}

	@Override
	public Cart addItemToCart(long userId, long menuItemId, long quantity) {
		 
	    Cart cart = cart_repo.findByUserUserId(userId).orElseGet(() -> {
	        UserInfo user = user_info_repo.findById(userId)
	            .orElseThrow(() -> new ResourceNotFoundException("User not found"));
	        Cart newCart = new Cart();
	        newCart.setUser(user);
	        return cart_repo.save(newCart);
	    });

	    
	    MenuItem menuItem = menu_item_repo.findById(menuItemId)
	        .orElseThrow(() -> new ResourceNotFoundException("Menu item not found"));

	    
	    CartItem cartItem = cart_item_repo.findByCartAndMenuItem(cart, menuItem)
	        .orElseGet(() -> {
	            CartItem newItem = new CartItem();
	            newItem.setCart(cart);
	            newItem.setMenuItem(menuItem);
	            newItem.setQuantity(0);
	            return newItem;
	        });

	    
	    cartItem.setQuantity(cartItem.getQuantity() + (int) quantity);

	    
	    cart_item_repo.save(cartItem);
	    return cart;
	    
	}

	@Override
	public Cart updateCartItem(long userId, long cartItemId, long quantity) {
		 Cart cart = cart_repo.findByUserUserId(userId)
			        .orElseThrow(() -> new ResourceNotFoundException("Cart not found for user id: " + userId));
		  CartItem cartItem = cart_item_repo.findById(cartItemId)
			        .orElseThrow(() -> new ResourceNotFoundException("Cart item not found with id: " + cartItemId));
		  if (quantity <= 0) {
		        cart_item_repo.delete(cartItem);
		    } else {
		        cartItem.setQuantity((int) quantity);
		        cart_item_repo.save(cartItem);
		    }
		  return cart;
	}

	@Override
	public void removeItemFromCart(long userId, long cartItemId) {
		
	    Cart cart = cart_repo.findByUserUserId(userId)
	        .orElseThrow(() -> new ResourceNotFoundException("Cart not found for user id: " + userId));

	   
	    CartItem cartItem = cart_item_repo.findById(cartItemId)
	        .orElseThrow(() -> new ResourceNotFoundException("Cart item not found with id: " + cartItemId));
	    
	    cart_item_repo.delete(cartItem);
		
	}

	@Override
	public void clearCart(long userId) {
		 Cart cart = cart_repo.findByUserUserId(userId)
			        .orElseThrow(() -> new ResourceNotFoundException("Cart not found for user id: " + userId));
		 List<CartItem> cartItems = cart_item_repo.findByCart(cart);
		 cart_item_repo.deleteAll(cartItems);
		 
		
	}

	

	

}
