package com.hexaware.hotbyte.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hexaware.hotbyte.entities.UserInfo;

public interface UserInfoRepository extends JpaRepository<UserInfo,Long>{

}
