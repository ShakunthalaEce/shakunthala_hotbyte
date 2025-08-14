package com.hexaware.hotbyte.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.hexaware.hotbyte.entities.OrderInfo;

public interface OrderInfoRepository extends JpaRepository<OrderInfo,Long> {
	 @Query("SELECT o FROM OrderInfo o WHERE o.user.user_id = :userId")
	    List<OrderInfo> findOrdersByUserId(@Param("userId") long userId);
}
