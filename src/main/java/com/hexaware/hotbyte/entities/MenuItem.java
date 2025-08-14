/*
 * Author: Shakunthala
 * Last Modified:7/8/25
 * Entity class for MenuItem
 * Mappings
*/
package com.hexaware.hotbyte.entities;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;

@Entity
public class MenuItem {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long menu_item_id;

	private String name;
	private String cuisine_type;// veg,non-veg,both
	private String description;
	private String image_url;
	private Double price;
	private String preparation_time;
	private String is_available;

	@ManyToOne
	@JoinColumn(name = "restaurant_id")
	@JsonIgnore
	@JsonBackReference
	private Restaurant restaurant;

	@ManyToOne
	@JoinColumn(name = "category_id")
	@JsonBackReference
	private Category category;

	@OneToMany(mappedBy = "menuItem", fetch = FetchType.EAGER)
	@JsonBackReference
	private List<OrderItem> orderItem;

	@OneToMany(mappedBy = "menuItem")
	@JsonIgnore
	@JsonManagedReference
	private List<CartItem> cartItems;

	public MenuItem(long menu_item_id, String name, String cuisine_type, String description, String image_url,
			Double price, String preparation_time, String is_available, Restaurant restaurant, Category category,
			List<OrderItem> orderItem, List<CartItem> cartItems) {
		super();
		this.menu_item_id = menu_item_id;
		this.name = name;
		this.cuisine_type = cuisine_type;
		this.description = description;
		this.image_url = image_url;
		this.price = price;
		this.preparation_time = preparation_time;
		this.is_available = is_available;
		this.restaurant = restaurant;
		this.category = category;
		this.orderItem = orderItem;
		this.cartItems = cartItems;
	}

	public List<CartItem> getCartItems() {
		return cartItems;
	}

	public void setCartItems(List<CartItem> cartItems) {
		this.cartItems = cartItems;
	}

	public MenuItem() {
	}

	public MenuItem(long menu_item_id, String name, String cuisine_type, String description, String image_url,
			Double price, String preparation_time, String is_available, Restaurant restaurant, Category category,
			List<OrderItem> orderItem) {
		super();
		this.menu_item_id = menu_item_id;
		this.name = name;
		this.cuisine_type = cuisine_type;
		this.description = description;
		this.image_url = image_url;
		this.price = price;
		this.preparation_time = preparation_time;
		this.is_available = is_available;
		this.restaurant = restaurant;
		this.category = category;
		this.orderItem = orderItem;
	}

	public long getMenu_item_id() {
		return menu_item_id;
	}

	public void setMenu_item_id(long menu_item_id) {
		this.menu_item_id = menu_item_id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCuisine_type() {
		return cuisine_type;
	}

	public void setCuisine_type(String cuisine_type) {
		this.cuisine_type = cuisine_type;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getImage_url() {
		return image_url;
	}

	public void setImage_url(String image_url) {
		this.image_url = image_url;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public String getPreparation_time() {
		return preparation_time;
	}

	public void setPreparation_time(String preparation_time) {
		this.preparation_time = preparation_time;
	}

	public String getIs_available() {
		return is_available;
	}

	public void setIs_available(String is_available) {
		this.is_available = is_available;
	}

	public Restaurant getRestaurant() {
		return restaurant;
	}

	public void setRestaurant(Restaurant restaurant) {
		this.restaurant = restaurant;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public List<OrderItem> getOrderItem() {
		return orderItem;
	}

	public void setOrderItem(List<OrderItem> orderItem) {
		this.orderItem = orderItem;
	}

	@Override
	public String toString() {
		return "MenuItem [menu_item_id=" + menu_item_id + ", name=" + name + ", cuisine_type=" + cuisine_type
				+ ", description=" + description + ", image_url=" + image_url + ", price=" + price
				+ ", preparation_time=" + preparation_time + ", is_available=" + is_available + ", restaurant="
				+ restaurant + ", category=" + category + ", orderItem=" + orderItem + "]";
	}

}
