package com.hexaware.hotbyte.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hexaware.hotbyte.entities.OrderInfo;

public interface OrderInfoRepository extends JpaRepository<OrderInfo,Long> {
	List<OrderInfo> findByUserUserId(long userId);
}
