package com.hexaware.hotbyte.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hexaware.hotbyte.entities.Order;

public interface OrderRepository extends JpaRepository<Order,Integer> {

}
