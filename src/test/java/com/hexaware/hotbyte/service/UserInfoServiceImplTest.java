package com.hexaware.hotbyte.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.hexaware.hotbyte.entities.UserInfo;

@SpringBootTest
class UserInfoServiceImplTest {
	
	@Autowired
	IUserInfoService service;

	@Test
	void testGetUserById() {
		long id=1;
		UserInfo user=service.getUserById(id);
		assertEquals(id, user.getUser_id());	
	}

	@Test
	void testGetAllUsers() {
		List<UserInfo>users;
		users=service.getAllUsers();
		assertNotNull(users);
	}

}
