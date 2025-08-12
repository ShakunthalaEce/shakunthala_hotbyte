package com.hexaware.hotbyte.service;

import java.util.List;

import com.hexaware.hotbyte.dto.AddressDto;
import com.hexaware.hotbyte.entities.Address;

public interface IAddressService {
	
	  Address addAddress(AddressDto addressDto, long userId);      
	  Address updateAddress(long addressId, AddressDto addressDto,long userId);
	  String deleteAddress(long addressId, long userId);             
	  List<Address> getAddressesByUser(long userId);              
}
