package com.hexaware.hotbyte.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hexaware.hotbyte.dto.MenuItemDto;
import com.hexaware.hotbyte.entities.Category;
import com.hexaware.hotbyte.entities.MenuItem;
import com.hexaware.hotbyte.entities.Restaurant;
import com.hexaware.hotbyte.exception.ResourceNotFoundException;
import com.hexaware.hotbyte.repository.CategoryRepository;
import com.hexaware.hotbyte.repository.MenuItemRepository;
import com.hexaware.hotbyte.repository.RestaurantRepository;

@Service
public class MenuItemServiceImpl implements IMenuItemService {

	  @Autowired
	    private MenuItemRepository menuItemRepo;

	    @Autowired
	    private RestaurantRepository restaurantRepo;

	    @Autowired
	    private CategoryRepository categoryRepo;

	    @Override
	    public MenuItem createMenuItem(MenuItemDto menuItemDto, long restaurantId) {
	        Restaurant restaurant = restaurantRepo.findById(restaurantId)
	                .orElseThrow(() -> new ResourceNotFoundException("Restaurant not found with id: " + restaurantId));
	        Category category = categoryRepo.findById(menuItemDto.getCategory_id())
	                .orElseThrow(() -> new ResourceNotFoundException("Category not found with id: " + menuItemDto.getCategory_id()));

	        MenuItem menuItem = new MenuItem();
	        menuItem.setName(menuItemDto.getName());
	        menuItem.setCuisine_type(menuItemDto.getCuisine_type());
	        menuItem.setDescription(menuItemDto.getDescription());
	        menuItem.setImage_url(menuItemDto.getImage_url());
	        menuItem.setPrice(menuItemDto.getPrice());
	        menuItem.setPreparation_time(menuItemDto.getPreparation_time());
	        menuItem.setIs_available(menuItemDto.getIs_available());
	        menuItem.setRestaurant(restaurant);
	        menuItem.setCategory(category);

	        return menuItemRepo.save(menuItem);
	    }

	    @Override
	    public MenuItem updateMenuItem(long menuItemId, MenuItemDto menuItemDto) {
	        MenuItem menuItem = menuItemRepo.findById(menuItemId)
	                .orElseThrow(() -> new ResourceNotFoundException("MenuItem not found with id: " + menuItemId));

	        Category category = categoryRepo.findById(menuItemDto.getCategory_id())
	                .orElseThrow(() -> new ResourceNotFoundException("Category not found with id: " + menuItemDto.getCategory_id()));

	        menuItem.setName(menuItemDto.getName());
	        menuItem.setCuisine_type(menuItemDto.getCuisine_type());
	        menuItem.setDescription(menuItemDto.getDescription());
	        menuItem.setImage_url(menuItemDto.getImage_url());
	        menuItem.setPrice(menuItemDto.getPrice());
	        menuItem.setPreparation_time(menuItemDto.getPreparation_time());
	        menuItem.setIs_available(menuItemDto.getIs_available());
	        menuItem.setCategory(category);

	        return menuItemRepo.save(menuItem);
	    }

	    @Override
	    public void deleteMenuItem(long menuItemId) {
	        MenuItem menuItem = menuItemRepo.findById(menuItemId)
	                .orElseThrow(() -> new ResourceNotFoundException("MenuItem not found with id: " + menuItemId));
	        menuItemRepo.delete(menuItem);
	    }

	    @Override
	    public MenuItem getMenuItemById(long menuItemId) {
	        return menuItemRepo.findById(menuItemId)
	                .orElseThrow(() -> new ResourceNotFoundException("MenuItem not found with id: " + menuItemId));
	    }

	    @Override
	    public List<MenuItem> getMenuItemsByCategory(long categoryId) {
	        Category category = categoryRepo.findById(categoryId)
	                .orElseThrow(() -> new ResourceNotFoundException("Category not found with id: " + categoryId));
	        return menuItemRepo.findByCategory(category);
	    }

	    @Override
	    public List<MenuItem> getMenuItemsByRestaurant(long restaurantId) {
	        Restaurant restaurant = restaurantRepo.findById(restaurantId)
	                .orElseThrow(() -> new ResourceNotFoundException("Restaurant not found with id: " + restaurantId));
	        return menuItemRepo.findByRestaurant(restaurant);
	    }

}
