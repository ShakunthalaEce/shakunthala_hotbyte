package com.hexaware.hotbyte.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class OrderItem {
	
	@Id
	private int order_item_id;
	
	private int quantity;
	private double price;
	
	@ManyToOne
	@JoinColumn(name="order_id")
	private Order order;
	
	@ManyToOne
	@JoinColumn(name="menu_item_id")
	private MenuItem menuItem;
	
	public OrderItem() {}

	public OrderItem(int order_item_id, int quantity, double price, Order order, MenuItem menuItem) {
		super();
		this.order_item_id = order_item_id;
		this.quantity = quantity;
		this.price = price;
		this.order = order;
		this.menuItem = menuItem;
	}

	public int getOrder_item_id() {
		return order_item_id;
	}

	public void setOrder_item_id(int order_item_id) {
		this.order_item_id = order_item_id;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public Order getOrder() {
		return order;
	}

	public void setOrder(Order order) {
		this.order = order;
	}

	public MenuItem getMenuItem() {
		return menuItem;
	}

	public void setMenuItem(MenuItem menuItem) {
		this.menuItem = menuItem;
	}

	@Override
	public String toString() {
		return "OrderItem [order_item_id=" + order_item_id + ", quantity=" + quantity + ", price=" + price + ", order="
				+ order + ", menuItem=" + menuItem + "]";
	}
	
	
}
