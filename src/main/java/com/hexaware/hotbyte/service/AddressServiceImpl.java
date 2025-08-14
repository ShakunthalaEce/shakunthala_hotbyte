/*
 * Author: Shakunthala
 * Last Modified:13/8/25
 * Address Service
 * 
 * Responsibility:
 * add,update,delete,get address
*/
package com.hexaware.hotbyte.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hexaware.hotbyte.dto.AddressDto;
import com.hexaware.hotbyte.entities.Address;
import com.hexaware.hotbyte.entities.UserInfo;
import com.hexaware.hotbyte.exception.ResourceNotFoundException;
import com.hexaware.hotbyte.repository.AddressRepository;
import com.hexaware.hotbyte.repository.UserInfoRepository;

@Service
public class AddressServiceImpl implements IAddressService {

	@Autowired
	AddressRepository repo;
	
	@Autowired
	UserInfoRepository userInfoRepo;

	@Override
	public Address addAddress(AddressDto addressDto, long userId) {
		UserInfo user = userInfoRepo.findById(userId)
				.orElseThrow(() -> new ResourceNotFoundException("User not found with id: " + userId));

		Address address = new Address();
		
		address.setAddress_line_1(addressDto.getAddressLine1());
		address.setAddress_line_2(addressDto.getAddressLine2());
		address.setCity(addressDto.getCity());
		address.setState(addressDto.getState());
		address.setPincode(addressDto.getPincode());
		address.setType(addressDto.getType());
		
		address.setUser(user);
		
		return repo.save(address);
	}

	@Override
	public Address updateAddress(long addressId, AddressDto addressDto, long userId) {
		Address address = new Address();

		address.setAddress_id(addressDto.getUserId());
		address.setAddress_line_1(addressDto.getAddressLine1());
		address.setAddress_line_2(addressDto.getAddressLine2());
		address.setCity(addressDto.getCity());
		address.setState(addressDto.getState());
		address.setPincode(addressDto.getPincode());
		address.setType(addressDto.getType());

		return repo.save(address);
	}

	@Override
	public String deleteAddress(long addressId, long userId) {
		Address address = repo.findById(addressId)
	            .orElseThrow(() -> new ResourceNotFoundException("Address not found"));

	    repo.delete(address);
	    return "Address deleted successfully";
	}

	@Override
	public List<Address> getAddressesByUser(long userId) {
		return repo.findAddressesByUserId(userId);
	}

}
