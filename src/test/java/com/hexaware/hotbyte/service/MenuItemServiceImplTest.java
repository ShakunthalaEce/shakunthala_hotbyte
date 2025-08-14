package com.hexaware.hotbyte.service;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.hexaware.hotbyte.entities.MenuItem;



@SpringBootTest
class MenuItemServiceImplTest {
	
	@Autowired
	IMenuItemService service;

	@Test
	void testGetMenuItemById() {
		long id=3;
		MenuItem menuItem=service.getMenuItemById(id);
		assertEquals(id,menuItem.getMenu_item_id());
	}

	@Test
	void testGetMenuItemsByCategory() {
		long id=4;
		List<MenuItem>menuItems;
		menuItems=service.getMenuItemsByCategory(id);
		assertNotNull(menuItems);
	}

	@Test
	void testGetMenuItemsByRestaurant() {
		long id=1;
		List<MenuItem>menu;
		menu=service.getMenuItemsByRestaurant(id);
		assertNotNull(menu);
	}

}
