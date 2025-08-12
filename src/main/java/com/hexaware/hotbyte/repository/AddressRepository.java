package com.hexaware.hotbyte.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hexaware.hotbyte.entities.Address;


public interface AddressRepository extends JpaRepository<Address,Long>{
	List<Address> findByUserId(long userId);
}
