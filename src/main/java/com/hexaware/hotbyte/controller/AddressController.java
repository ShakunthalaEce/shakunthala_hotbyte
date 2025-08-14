/*
 * Author: Shakunthala
 * Last Modified:13/8/25
 * Address Controller
 * 
 * Responsibility:
 * add,update,delete,get address
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

import com.hexaware.hotbyte.dto.AddressDto;
import com.hexaware.hotbyte.entities.Address;
import com.hexaware.hotbyte.service.IAddressService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/address")
public class AddressController {

	@Autowired
	IAddressService service;

	@PostMapping("/add/{userId}")
	@PreAuthorize("hasAnyRole('USER', 'ADMIN')")
	public Address addAddress(@RequestBody @Valid AddressDto addressDto, @PathVariable long userId) {
		return service.addAddress(addressDto, userId);
	}

	@PutMapping("/update/{addressId}/{userId}")
	@PreAuthorize("hasAnyRole('USER', 'ADMIN')")
	public Address updateAddress(@PathVariable long addressId, @RequestBody AddressDto addressDto,
			@PathVariable long userId) {

		return service.updateAddress(addressId, addressDto, userId);
	}
	
	@PreAuthorize("hasAnyRole('USER', 'ADMIN')")
	@DeleteMapping("/delete/{addressId}/{userId}")
	public String deleteAddress(@PathVariable long addressId, @PathVariable long userId) {
		String message = service.deleteAddress(addressId, userId);
		return message;
	}

	@PreAuthorize("hasAnyRole('USER', 'ADMIN')")
	@GetMapping("/user/{userId}")
	public List<Address> getAddressesByUser(@PathVariable long userId) {
		List<Address> addresses = service.getAddressesByUser(userId);
		return addresses;
	}

}
