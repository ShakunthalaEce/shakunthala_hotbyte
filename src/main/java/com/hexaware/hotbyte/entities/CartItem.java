package com.hexaware.hotbyte.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class CartItem {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long cart_item_id;
	private int quantity;
	
	@ManyToOne
	@JoinColumn(name = "cart_id")
	private Cart cart;

	@ManyToOne
	@JoinColumn(name = "menu_item_id")
	private MenuItem menuItem;
	
	public CartItem() {}
	
	
	
	public CartItem(long cart_item_id, int quantity, Cart cart, MenuItem menuItem) {
		super();
		this.cart_item_id = cart_item_id;
		this.quantity = quantity;
		this.cart = cart;
		this.menuItem = menuItem;
	}

	public long getCart_item_id() {
		return cart_item_id;
	}

	public void setCart_item_id(long cart_item_id) {
		this.cart_item_id = cart_item_id;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public Cart getCart() {
		return cart;
	}

	public void setCart(Cart cart) {
		this.cart = cart;
	}

	public MenuItem getMenuItem() {
		return menuItem;
	}

	public void setMenuItem(MenuItem menuItem2) {
		this.menuItem = menuItem2;
	}

	@Override
	public String toString() {
		return "CartItem [cart_item_id=" + cart_item_id + ", quantity=" + quantity + ", cart=" + cart + ", menuItem="
				+ menuItem + "]";
	}
	
}
