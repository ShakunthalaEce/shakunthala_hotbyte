/*
 * Author: Shakunthala
 * Last Modified:7/8/25
 * Entity class for Category
 * Mappings
*/
package com.hexaware.hotbyte.entities;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;

@Entity
public class Category {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long category_id;
	private String name;
	private String description;
	
	@OneToMany(mappedBy="category")
	@JsonManagedReference
	List<MenuItem>menuItems;
	
	@ManyToMany(mappedBy = "categories")
	@JsonBackReference
    private List<Restaurant> restaurants;
	
	
	public Category() {}

	public Category(long category_id, String name, String description, List<MenuItem> menuItems,
			List<Restaurant> restaurants) {
		super();
		this.category_id = category_id;
		this.name = name;
		this.description = description;
		this.menuItems = menuItems;
		this.restaurants = restaurants;
	}

	public long getCategory_id() {
		return category_id;
	}

	public void setCategory_id(long l) {
		this.category_id = l;
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
