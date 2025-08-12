package com.hexaware.hotbyte.entities;

import java.util.List;

import com.hexaware.hotbyte.enums.UserRole;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="users")
public class UserInfo {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long user_id;
	
	private String name;
	private String email;
	private String password;
	private String phone_number;
	
	@Enumerated(EnumType.STRING)
	private UserRole role;
	
	@OneToMany(mappedBy = "user")
	private List<Address> addresses;
	
	@OneToOne(mappedBy="user")
	private Cart cart;
	
	@OneToOne(mappedBy="user")
	private Restaurant restaurant;
	
	@OneToMany(mappedBy="user")
	private List<OrderInfo> orders;
	
	public UserInfo() {}

	public UserInfo(long user_id, String name, String email, String password, String phone_number, UserRole role,
			List<Address> addresses, Cart cart, Restaurant restaurant, List<OrderInfo> orders) {
		super();
		this.user_id = user_id;
		this.name = name;
		this.email = email;
		this.password = password;
		this.phone_number = phone_number;
		this.role = role;
		this.addresses = addresses;
		this.cart = cart;
		this.restaurant = restaurant;
		this.orders = orders;
	}

	public long getUser_id() {
		return user_id;
	}

	public void setUser_id(long user_id) {
		this.user_id = user_id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPhone_number() {
		return phone_number;
	}

	public void setPhone_number(String phone_number) {
		this.phone_number = phone_number;
	}

	public UserRole getRole() {
		return role;
	}

	public void setRole(UserRole role) {
		this.role = role;
	}

	public List<Address> getAddresses() {
		return addresses;
	}

	public void setAddresses(List<Address> addresses) {
		this.addresses = addresses;
	}

	public Cart getCart() {
		return cart;
	}

	public void setCart(Cart cart) {
		this.cart = cart;
	}

	public Restaurant getRestaurant() {
		return restaurant;
	}

	public void setRestaurant(Restaurant restaurant) {
		this.restaurant = restaurant;
	}

	public List<OrderInfo> getOrders() {
		return orders;
	}

	public void setOrders(List<OrderInfo> orders) {
		this.orders = orders;
	}

	@Override
	public String toString() {
		return "User [user_id=" + user_id + ", name=" + name + ", email=" + email + ", password=" + password
				+ ", phone_number=" + phone_number + ", role=" + role + ", addresses=" + addresses + ", cart=" + cart
				+ ", restaurant=" + restaurant + ", orders=" + orders + "]";
	}
	
	
	
}
