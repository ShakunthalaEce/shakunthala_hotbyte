/*
 * Author: Shakunthala
 * Last Modified:7/8/25
 * Entity class for Restaurant
 * Mappings
*/

package com.hexaware.hotbyte.entities;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;

@Entity
public class Restaurant {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long restaurant_id;
	private String restaurant_name;
	private String phone_number;
	private String city;
	private String state;
	private String pincode;
	
	@OneToOne
	@JoinColumn(name="user_id")
	@JsonBackReference
	private UserInfo user;
	
	
	@OneToMany(mappedBy="restaurant")
	@JsonManagedReference
	private List<MenuItem> menuItems;
	
	@OneToMany(mappedBy="restaurant")
	@JsonIgnore
	@JsonManagedReference
	private List<OrderInfo>orders;
	
	 @ManyToMany
	 @JoinTable(
	 name = "restaurant_category",
	 joinColumns = @JoinColumn(name = "restaurant_id"),
	 inverseJoinColumns = @JoinColumn(name = "category_id")
	 )
	 @JsonManagedReference
	 @JsonIgnore
	 private List<Category> categories;
	 
	 public Restaurant() {}

	 public Restaurant(long restaurant_id, String restaurant_name, String phone_number, String city, String state,
			String pincode, UserInfo user, List<MenuItem> menuItems, List<OrderInfo> orders, List<Category> categories) {
		super();
		this.restaurant_id = restaurant_id;
		this.restaurant_name = restaurant_name;
		this.phone_number = phone_number;
		this.city = city;
		this.state = state;
		this.pincode = pincode;
		this.user = user;
		this.menuItems = menuItems;
		this.orders = orders;
		this.categories = categories;
	}

	 public long getRestaurant_id() {
		 return restaurant_id;
	 }

	 public void setRestaurant_id(long restaurant_id) {
		 this.restaurant_id = restaurant_id;
	 }

	 public String getRestaurant_name() {
		 return restaurant_name;
	 }

	 public void setRestaurant_name(String restaurant_name) {
		 this.restaurant_name = restaurant_name;
	 }

	 public String getPhone_number() {
		 return phone_number;
	 }

	 public void setPhone_number(String phone_number) {
		 this.phone_number = phone_number;
	 }

	 public String getCity() {
		 return city;
	 }

	 public void setCity(String city) {
		 this.city = city;
	 }

	 public String getState() {
		 return state;
	 }

	 public void setState(String state) {
		 this.state = state;
	 }

	 public String getPincode() {
		 return pincode;
	 }

	 public void setPincode(String pincode) {
		 this.pincode = pincode;
	 }

	 public UserInfo getUser() {
		 return user;
	 }

	 public void setUser(UserInfo user) {
		 this.user = user;
	 }

	 public List<MenuItem> getMenuItems() {
		 return menuItems;
	 }

	 public void setMenuItems(List<MenuItem> menuItems) {
		 this.menuItems = menuItems;
	 }

	 public List<OrderInfo> getOrders() {
		 return orders;
	 }

	 public void setOrders(List<OrderInfo> orders) {
		 this.orders = orders;
	 }

	 public List<Category> getCategories() {
		 return categories;
	 }

	 public void setCategories(List<Category> categories) {
		 this.categories = categories;
	 }

	 @Override
	 public String toString() {
		return "Restaurant [restaurant_id=" + restaurant_id + ", restaurant_name=" + restaurant_name + ", phone_number="
				+ phone_number + ", city=" + city + ", state=" + state + ", pincode=" + pincode + ", user=" + user
				+ ", menuItems=" + menuItems + ", orders=" + orders + ", categories=" + categories + "]";
	 }
	 
	 
	 
	
}
