package com.hexaware.hotbyte.service;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.junit.jupiter.api.Disabled;

import com.hexaware.hotbyte.dto.AddressDto;
import com.hexaware.hotbyte.entities.Address;

@SpringBootTest
class AddressServiceImplTest {
	
	@Autowired
	IAddressService service;

	@Test
	void testGetAddressesByUser() {
		long id=1;
		List<Address> addresses = service.getAddressesByUser(id);
		assertNotNull(addresses);	
	}
	
	@Disabled
	void testUpdateAddress()
	{
		long userId = 1; 
		long addressId = 3; 
		
		AddressDto updatedAddressDto = new AddressDto();
		updatedAddressDto.setUserId(userId);
		updatedAddressDto.setAddressId(addressId);
		updatedAddressDto.setAddressLine1("TK Nagar");
		updatedAddressDto.setCity("Coimbatore");
		updatedAddressDto.setPincode("123456");
		Address updatedAddress = service.updateAddress(addressId, updatedAddressDto, userId);
		assertNotNull(updatedAddress);
		assertTrue(updatedAddress.getCity().equals("Coimbatore"));
		
	}
	@Disabled
	void testDeleteAddress(long addressId, long userId)
	{
		service.deleteAddress(2, 1);
	}
	void testGetAddressesByUser(long userId)
	{
		
	}

}
