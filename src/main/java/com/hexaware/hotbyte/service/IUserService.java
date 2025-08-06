package com.hexaware.hotbyte.service;

import java.util.List;

import com.hexaware.hotbyte.entities.User;

public interface IUserService {
	public int addUser(User user);
	public int updateUser(User user);
	public List<User>getUsers();
	public User getUserById(int id);
}
