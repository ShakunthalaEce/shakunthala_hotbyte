/*
 * Author: Shakunthala
 * Last Modified:7/8/25
 * Entity class for Cart
 * Mappings
*/
package com.hexaware.hotbyte.entities;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="cart")
public class Cart {
	
	@Id 
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long cart_id;
	
	@OneToOne
	@JoinColumn(name="user_id")
	@JsonBackReference
	private UserInfo user;
	
	 @OneToOne
	 @JoinColumn(name = "restaurant_id")
	 @JsonBackReference
	 private Restaurant restaurant;
	 
	 @OneToMany(mappedBy = "cart",cascade = CascadeType.ALL)
	 @JsonManagedReference
	 private List<CartItem> cartItems;
	 
	 public Cart() {}

	 public Cart(long cart_id, UserInfo user, Restaurant restaurant, List<CartItem> cartItems) {
		super();
		this.cart_id = cart_id;
		this.user = user;
		this.restaurant = restaurant;
		this.cartItems = cartItems;
	}

	 public long getCart_id() {
		return cart_id;
	}

	public void setCart_id(long cart_id) {
		this.cart_id = cart_id;
	}

	public UserInfo getUser() {
		return user;
	}

	public void setUser(UserInfo user) {
		this.user = user;
	}

	public Restaurant getRestaurant() {
		return restaurant;
	}

	public void setRestaurant(Restaurant restaurant) {
		this.restaurant = restaurant;
	}
	
	public List<CartItem> getCartItems() {
		return cartItems;
	}

	public void setCartItems(List<CartItem> cartItems) {
		this.cartItems = cartItems;
	}

	@Override
	public String toString() {
		return "Cart [cart_id=" + cart_id + ", user=" + user + ", restaurant=" + restaurant + ", cartItems=" + cartItems + "]";
	}
}