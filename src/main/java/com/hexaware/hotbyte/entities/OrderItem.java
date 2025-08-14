/*
 * Author: Shakunthala
 * Last Modified:7/8/25
 * Entity class for OrderItem
 * Mappings
*/
package com.hexaware.hotbyte.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class OrderItem {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long order_item_id;
	
	private int quantity;
	private double price;
	
	@ManyToOne
	@JoinColumn(name="order_id")
	@JsonBackReference
	private OrderInfo order;
	
	@ManyToOne
	@JoinColumn(name="menu_item_id")
	private MenuItem menuItem;
	
	public OrderItem() {}

	public OrderItem(long order_item_id, int quantity, double price, OrderInfo order, MenuItem menuItem) {
		super();
		this.order_item_id = order_item_id;
		this.quantity = quantity;
		this.price = price;
		this.order = order;
		this.menuItem = menuItem;
	}

	public long getOrder_item_id() {
		return order_item_id;
	}

	public void setOrder_item_id(long order_item_id) {
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

	public OrderInfo getOrder() {
		return order;
	}

	public void setOrder(OrderInfo order) {
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
