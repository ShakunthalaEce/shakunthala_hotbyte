/*
 * Author: Shakunthala
 * Last Modified:13/8/25
 * Menu Item Controller
 * 
 * Responsibility:
 * add,update,delete,get menuItems
*/

package com.hexaware.hotbyte.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hexaware.hotbyte.dto.MenuItemDto;
import com.hexaware.hotbyte.entities.MenuItem;
import com.hexaware.hotbyte.service.IMenuItemService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/menuItem")
public class MenuItemController {
	@Autowired
	IMenuItemService service;

	@PostMapping("/create/{restaurantId}")
	@PreAuthorize("hasAnyRole('RESTAURANT_OWNER', 'ADMIN')")
	public MenuItem createMenuItem(@RequestBody @Valid MenuItemDto menuItemDto, @PathVariable long restaurantId) {
		return service.createMenuItem(menuItemDto, restaurantId);
	}

	@PutMapping("/update/{menuItemId}")
	@PreAuthorize("hasAnyRole('RESTAURANT_OWNER', 'ADMIN')")
	public MenuItem updateMenuItem(@PathVariable long menuItemId, @RequestBody MenuItemDto menuItemDto) {
		return service.updateMenuItem(menuItemId, menuItemDto);
	}

	@DeleteMapping("/delete/{menuItemId}")
	@PreAuthorize("hasAnyRole('RESTAURANT_OWNER', 'ADMIN')")
	public void deleteMenuItem(@PathVariable long menuItemId) {
		service.deleteMenuItem(menuItemId);
	}

	@GetMapping("/get/{menuItemId}")
	@PreAuthorize("hasAnyRole('USER', 'RESTAURANT_OWNER', 'ADMIN')")
	public MenuItem getMenuItemById(@PathVariable long menuItemId) {
		return service.getMenuItemById(menuItemId);
	}

	@GetMapping("/category/{categoryId}")
	@PreAuthorize("hasAnyRole('USER', 'RESTAURANT_OWNER', 'ADMIN')")
	public List<MenuItem> getMenuItemsByCategory(@PathVariable long categoryId) {
		return service.getMenuItemsByCategory(categoryId);
	}

	@GetMapping("/restaurant/{restaurantId}")
	@PreAuthorize("hasAnyRole('USER', 'RESTAURANT_OWNER', 'ADMIN')")
	public List<MenuItem> getMenuItemsByRestaurant(@PathVariable long restaurantId) {
		return service.getMenuItemsByRestaurant(restaurantId);
	}
	
	
}
