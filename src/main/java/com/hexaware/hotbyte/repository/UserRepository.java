package com.hexaware.hotbyte.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hexaware.hotbyte.entities.User;

public interface UserRepository extends JpaRepository<User,Integer>{

}
