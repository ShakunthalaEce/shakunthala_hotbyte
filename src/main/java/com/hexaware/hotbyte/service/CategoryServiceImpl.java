/*
 * Author: Shakunthala
 * Last Modified:13/8/25
 * Category Service
 * 
 * Responsibility:
 * add,update,delete,get category
*/
package com.hexaware.hotbyte.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hexaware.hotbyte.dto.CategoryDto;
import com.hexaware.hotbyte.entities.Category;
import com.hexaware.hotbyte.exception.ResourceNotFoundException;
import com.hexaware.hotbyte.repository.CategoryRepository;

@Service
public class CategoryServiceImpl implements ICategoryService {
	
	@Autowired
	CategoryRepository repo;

	@Override
	public Category createCategory(CategoryDto categoryDto) {
		Category category = new Category();
		category.setCategory_id(categoryDto.getCategory_id());
		category.setName(categoryDto.getName());
		category.setDescription(categoryDto.getDescription());
		
		return repo.save(category);
		
	}

	@Override
	public Category updateCategory(Long categoryId, CategoryDto categoryDto) {
		Category category = new Category();
		category.setCategory_id(categoryDto.getCategory_id());
		category.setName(categoryDto.getName());
		category.setDescription(categoryDto.getDescription());
		
		return repo.save(category);
	}

	@Override
	public void deleteCategory(Long categoryId) {
		if (!repo.existsById(categoryId)) {
	        throw new ResourceNotFoundException("Category not found with id: " + categoryId);
	    }
	    repo.deleteById(categoryId);
		
	}

	@Override
	public List<Category> getAllCategories() {
		return repo.findAll();
	}
	
	public List<Category> getCategoriesByIds(List<Long> categoryIds) {
        return repo.findAllById(categoryIds);
    }

}
