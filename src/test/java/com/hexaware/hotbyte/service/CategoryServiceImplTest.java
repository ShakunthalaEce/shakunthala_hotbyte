package com.hexaware.hotbyte.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
//import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.hexaware.hotbyte.entities.Category;


@SpringBootTest
class CategoryServiceImplTest {
	
	@Autowired
	ICategoryService service;

	@Test
	void testGetAllCategories() {
		List<Category>categories;
		categories=service.getAllCategories();
		assertNotNull(categories);
	}

	@Test
	void testGetCategoriesByIds() {
		
		List<Long> ids = Arrays.asList(1L, 3L, 4L); 
        List<Category> categories = service.getCategoriesByIds(ids);
        assertNotNull(categories); 
        assertEquals(1, categories.size()); 
		
	}

}
