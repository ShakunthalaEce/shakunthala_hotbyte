/*
 * Author: Shakunthala
 * Last Modified:13/8/25
 * User Service
 * 
 * Responsibility:
 * add,update,delete,get user
*/
package com.hexaware.hotbyte.service;

import java.util.Collections;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.hexaware.hotbyte.entities.UserInfo;
import com.hexaware.hotbyte.repository.UserInfoRepository;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private UserInfoRepository userInfoRepo;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        UserInfo user = userInfoRepo.findByEmail(email)
                .orElseThrow(() -> new UsernameNotFoundException("User not found with email: " + email));

        return new org.springframework.security.core.userdetails.User(
                user.getEmail(), 
                user.getPassword(),
                Collections.singletonList(new SimpleGrantedAuthority("ROLE_" + user.getRole().name()))
        );
    }
}