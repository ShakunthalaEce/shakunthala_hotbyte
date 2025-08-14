/*
 * Author: Shakunthala
 * Last Modified:13/8/25
 * Category Controller
 * 
 * Responsibility:
 * add,update,delete,get catgeory
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

import com.hexaware.hotbyte.dto.CategoryDto;
import com.hexaware.hotbyte.entities.Category;
import com.hexaware.hotbyte.service.ICategoryService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/category")
public class CategoryController {
	@Autowired
	ICategoryService service;

	@PostMapping("/create")
	@PreAuthorize("hasRole('ADMIN')")
	public Category createCategory(@RequestBody @Valid CategoryDto categoryDto) {
		return service.createCategory(categoryDto);
	}

	@PutMapping("/update/{categoryId}")
	@PreAuthorize("hasRole('ADMIN')")
	public Category updateCategory(@PathVariable Long categoryId, @RequestBody CategoryDto categoryDto) {
		
		return service.updateCategory(categoryId, categoryDto);
	}

	@DeleteMapping("/delete/{categoryId}")
	@PreAuthorize("hasRole('ADMIN')")
	public void deleteCategory(@PathVariable Long categoryId) {
		service.deleteCategory(categoryId);
	}

	@GetMapping("/all")
	@PreAuthorize("hasAnyRole('USER', 'ADMIN', 'RESTAURANT_OWNER')")
	public List<Category> getAllCategories() {
		return service.getAllCategories();
	}
}
