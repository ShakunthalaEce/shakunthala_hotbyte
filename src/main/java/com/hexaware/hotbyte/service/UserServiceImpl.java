package com.hexaware.hotbyte.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hexaware.hotbyte.dto.UserInfoDto;
import com.hexaware.hotbyte.entities.UserInfo;
import com.hexaware.hotbyte.enums.UserRole;
import com.hexaware.hotbyte.exception.ResourceNotFoundException;
import com.hexaware.hotbyte.repository.UserInfoRepository;

@Service
public class UserServiceImpl implements IUserService {
	
	@Autowired
	UserInfoRepository userInfoRepo;

	@Override
	public UserInfo registerUser(UserInfoDto userInfoDto) {
		 UserInfo user = new UserInfo();

		    user.setName(userInfoDto.getName());
		    user.setEmail(userInfoDto.getEmail());
		    user.setPassword(userInfoDto.getPassword());
		    user.setPhone_number(userInfoDto.getPhoneNumber());

		   
		    try {
		        user.setRole(UserRole.valueOf(userInfoDto.getRole().toUpperCase()));
		    } catch (IllegalArgumentException e) {
		        throw new IllegalArgumentException("Invalid role: " + userInfoDto.getRole());
		    }

		   
		    return userInfoRepo.save(user);
		
	}

	@Override
	public UserInfo updateUser(Long userId, UserInfoDto userInfoDto) {
	    UserInfo existingUser = userInfoRepo.findById(userId)
	        .orElseThrow(() -> new ResourceNotFoundException("User not found with id: " + userId));

	    existingUser.setName(userInfoDto.getName());
	    existingUser.setEmail(userInfoDto.getEmail());
	    existingUser.setPassword(userInfoDto.getPassword());
	    existingUser.setPhone_number(userInfoDto.getPhoneNumber());

	    UserRole role;
	    try {
	        role = UserRole.valueOf(userInfoDto.getRole());
	    } catch (IllegalArgumentException e) {
	        throw new IllegalArgumentException("Invalid role: " + userInfoDto.getRole());
	    }
	    existingUser.setRole(role);

	    return userInfoRepo.save(existingUser);
	}

	@Override
	public void deleteUser(Long userId) {
		userInfoRepo.deleteById(userId);
		
	}

	@Override
	public UserInfo getUserById(Long userId) {
		return userInfoRepo.findById(userId).orElseThrow(() -> new ResourceNotFoundException("User not found with id: " + userId));
	}

	@Override
	public List<UserInfo> getAllUsers() {
		return userInfoRepo.findAll();
	}

	

}
