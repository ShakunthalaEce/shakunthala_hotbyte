package com.hexaware.hotbyte.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hexaware.hotbyte.entities.Restaurant;

public interface RestaurantRepository extends JpaRepository<Restaurant,Integer> {

}
