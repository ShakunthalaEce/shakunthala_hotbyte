/*
 * Author: Shakunthala
 * Last Modified:13/8/25
 * User Controller
 * 
 * Responsibility:
 * add,update,delete,get user
*/

package com.hexaware.hotbyte.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hexaware.hotbyte.dto.UserInfoDto;
import com.hexaware.hotbyte.entities.UserInfo;
import com.hexaware.hotbyte.service.IUserInfoService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/userInfo")
public class UserInfoController {
	@Autowired
	IUserInfoService service;

	@PostMapping("/register")
	public UserInfo registerUser(@RequestBody @Valid UserInfoDto userInfoDto) {
		return service.registerUser(userInfoDto);
	}

	@PutMapping("/update/{userId}")
	@PreAuthorize("hasAnyRole('USER', 'ADMIN')")
	public UserInfo updateUser(@PathVariable Long userId, @RequestBody UserInfoDto userInfoDto) {
		return service.updateUser(userId, userInfoDto);
	}

	@DeleteMapping("/delete/{userId}")
	@PreAuthorize("hasRole('ADMIN')")
	public void deleteUser(@PathVariable Long userId) {
		service.deleteUser(userId);
	}

	@GetMapping("/get/{userId}")
	@PreAuthorize("hasAnyRole('USER', 'ADMIN')")
	public UserInfo getUserById(@PathVariable Long userId) {
		return service.getUserById(userId);
	}

	@GetMapping("/all")
	@PreAuthorize("hasRole('ADMIN')")
	public List<UserInfo> getAllUsers() {
		return service.getAllUsers();
	}
}
