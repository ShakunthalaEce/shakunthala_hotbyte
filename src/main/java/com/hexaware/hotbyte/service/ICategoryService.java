package com.hexaware.hotbyte.service;

import java.util.List;

import com.hexaware.hotbyte.dto.CategoryDto;
import com.hexaware.hotbyte.entities.Category;

public interface ICategoryService {
	Category createCategory(CategoryDto categoryDto);

	Category updateCategory(Long categoryId, CategoryDto categoryDto);

	void deleteCategory(Long categoryId);

	List<Category> getAllCategories();
	
	List<Category> getCategoriesByIds(List<Long> categoryIds);
}
