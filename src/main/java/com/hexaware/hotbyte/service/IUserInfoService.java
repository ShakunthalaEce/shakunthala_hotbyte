package com.hexaware.hotbyte.service;

import java.util.List;

import com.hexaware.hotbyte.dto.UserInfoDto;
import com.hexaware.hotbyte.entities.UserInfo;

public interface IUserInfoService {
	UserInfo registerUser(UserInfoDto userInfoDto);

	UserInfo updateUser(Long userId, UserInfoDto userInfoDto);

	void deleteUser(Long userId);

	UserInfo getUserById(Long userId);

	List<UserInfo> getAllUsers();
}
