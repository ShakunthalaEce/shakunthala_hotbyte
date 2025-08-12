package com.hexaware.hotbyte.entities;

import java.time.LocalDate;
import java.util.List;

import com.hexaware.hotbyte.enums.OrderStatus;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "orders")
public class OrderInfo {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long order_id;
	private double total_amount;
	private LocalDate order_time;
	
	
	@Enumerated(EnumType.STRING)
	private OrderStatus status;
	
	@ManyToOne
	@JoinColumn(name = "user_id")
	private UserInfo user;
	
	@ManyToOne
	@JoinColumn(name="restaurant_id")
	private Restaurant restaurant;
	
	@ManyToOne
	@JoinColumn(name = "shipping_address_id")
	private Address shippingAddress;
	


	
	@OneToMany(mappedBy="order")
	private List<OrderItem>orderItem;

	
	public OrderInfo() {}


	public OrderInfo(long order_id, double total_amount, LocalDate order_time, OrderStatus status, UserInfo user,
			Restaurant restaurant, Address shippingAddress, List<OrderItem> orderItem) {
		super();
		this.order_id = order_id;
		this.total_amount = total_amount;
		this.order_time = order_time;
		this.status = status;
		this.user = user;
		this.restaurant = restaurant;
		this.shippingAddress = shippingAddress;
		this.orderItem = orderItem;
	}




	public long getOrder_id() {
		return order_id;
	}




	public void setOrder_id(long order_id) {
		this.order_id = order_id;
	}




	public double getTotal_amount() {
		return total_amount;
	}




	public void setTotal_amount(double total_amount) {
		this.total_amount = total_amount;
	}




	public LocalDate getOrder_time() {
		return order_time;
	}




	public void setOrder_time(LocalDate order_time) {
		this.order_time = order_time;
	}




	public OrderStatus getStatus() {
		return status;
	}




	public void setStatus(OrderStatus status) {
		this.status = status;
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




	public Address getShippingAddress() {
		return shippingAddress;
	}




	public void setShippingAddress(Address shippingAddress) {
		this.shippingAddress = shippingAddress;
	}




	public List<OrderItem> getOrderItem() {
		return orderItem;
	}




	public void setOrderItem(List<OrderItem> orderItem) {
		this.orderItem = orderItem;
	}




	@Override
	public String toString() {
		return "Order [order_id=" + order_id + ", total_amount=" + total_amount + ", order_time=" + order_time
				+ ", status=" + status + ", user=" + user + ", restaurant=" + restaurant + ", shippingAddress="
				+ shippingAddress + ", orderItem=" + orderItem + "]";
	}
	
	
	

}
