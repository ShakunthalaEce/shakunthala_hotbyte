package com.hexaware.hotbyte.service;

import java.util.List;

import com.hexaware.hotbyte.entities.Address;

public interface IAddressService {
	public int addAddress(Address address);
	public int updateAddress(Address address);
	public List<Address> getAllAddress();
	public Address getAddressById(int id);
}
