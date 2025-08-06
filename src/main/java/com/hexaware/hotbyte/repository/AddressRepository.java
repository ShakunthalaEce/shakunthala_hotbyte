package com.hexaware.hotbyte.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hexaware.hotbyte.entities.Address;


public interface AddressRepository extends JpaRepository<Address,Integer>{

}
