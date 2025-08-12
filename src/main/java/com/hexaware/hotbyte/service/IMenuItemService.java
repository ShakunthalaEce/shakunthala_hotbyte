package com.hexaware.hotbyte.service;

import java.util.List;

import com.hexaware.hotbyte.dto.MenuItemDto;
import com.hexaware.hotbyte.entities.MenuItem;

public interface IMenuItemService {
	MenuItem createMenuItem(MenuItemDto menuItemDto, long restaurantId); 

	MenuItem updateMenuItem(long menuItemId, MenuItemDto menuItemDto); 

	void deleteMenuItem(long menuItemId);

	MenuItem getMenuItemById(long menuItemId); 

	List<MenuItem> getMenuItemsByCategory(long categoryId); 

	List<MenuItem> getMenuItemsByRestaurant(long restaurantId);
}
