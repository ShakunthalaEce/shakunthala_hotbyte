package com.hexaware.hotbyte.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
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
	private UserInfo user;
	
	 @OneToOne
	 @JoinColumn(name = "restaurant_id")
	 private Restaurant restaurant;
	 
	 public Cart() {}
	
	 public Cart(long cart_id, UserInfo user, Restaurant restaurant) {
		super();
		this.cart_id = cart_id;
		this.user = user;
		this.restaurant = restaurant;
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

	@Override
	public String toString() {
		return "Cart [cart_id=" + cart_id + ", user=" + user + ", restaurant=" + restaurant + "]";
	}

	
}
