package com.hexaware.hotbyte.service;

import org.springframework.security.core.userdetails.UserDetails;

public interface UserDetailsService {
	public UserDetails loadUserByUsername(String email);
}
