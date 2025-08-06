package com.hexaware.hotbyte.entities;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;

@Entity
public class Category {
	
	@Id
	private int category_id;
	private String name;
	private String description;
	
	@OneToMany(mappedBy="category")
	List<MenuItem>menuItems;
	
	@ManyToMany(mappedBy = "categories")
    private List<Restaurant> restaurants;
	
	
	public Category() {}

	public Category(int category_id, String name, String description, List<MenuItem> menuItems,
			List<Restaurant> restaurants) {
		super();
		this.category_id = category_id;
		this.name = name;
		this.description = description;
		this.menuItems = menuItems;
		this.restaurants = restaurants;
	}

	public int getCategory_id() {
		return category_id;
	}

	public void setCategory_id(int category_id) {
		this.category_id = category_id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public List<MenuItem> getMenuItems() {
		return menuItems;
	}

	public void setMenuItems(List<MenuItem> menuItems) {
		this.menuItems = menuItems;
	}

	public List<Restaurant> getRestaurants() {
		return restaurants;
	}

	public void setRestaurants(List<Restaurant> restaurants) {
		this.restaurants = restaurants;
	}

	@Override
	public String toString() {
		return "Category [category_id=" + category_id + ", name=" + name + ", description=" + description
				+ ", menuItems=" + menuItems + ", restaurants=" + restaurants + "]";
	}
	
	
	
}
