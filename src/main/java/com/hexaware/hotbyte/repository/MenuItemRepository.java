package com.hexaware.hotbyte.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hexaware.hotbyte.entities.MenuItem;

public interface MenuItemRepository extends JpaRepository<MenuItem,Integer>{

}
