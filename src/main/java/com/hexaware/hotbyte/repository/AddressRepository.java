package com.hexaware.hotbyte.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.hexaware.hotbyte.entities.Address;


public interface AddressRepository extends JpaRepository<Address,Long>{
	 @Query("SELECT a FROM Address a WHERE a.user.user_id = ?1")
	    List<Address> findAddressesByUserId(long userId);
}
