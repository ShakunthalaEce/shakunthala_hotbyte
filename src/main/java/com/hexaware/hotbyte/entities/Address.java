package com.hexaware.hotbyte.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="addresses")
public class Address {
	
	
	private String address_line_1;
	private String address_line_2;
	private String city;
	private String state;
	private String pincode;
	private String type;
	
	@ManyToOne
	@JoinColumn(name = "user_id")
	private User user;
	
	@Id
	private int address_id;
	
	public Address() {}
	

	public Address(String address_line_1, String address_line_2, String city, String state, String pincode, String type,
			User user, int address_id) {
		super();
		this.address_line_1 = address_line_1;
		this.address_line_2 = address_line_2;
		this.city = city;
		this.state = state;
		this.pincode = pincode;
		this.type = type;
		this.user = user;
		this.address_id = address_id;
	}

	public int getAddress_id() {
		return address_id;
	}

	public void setAddress_id(int address_id) {
		this.address_id = address_id;
	}

	public String getAddress_line_1() {
		return address_line_1;
	}

	public void setAddress_line_1(String address_line_1) {
		this.address_line_1 = address_line_1;
	}

	public String getAddress_line_2() {
		return address_line_2;
	}

	public void setAddress_line_2(String address_line_2) {
		this.address_line_2 = address_line_2;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getPincode() {
		return pincode;
	}

	public void setPincode(String pincode) {
		this.pincode = pincode;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	
	
	
	@Override
	public String toString() {
		return "Address [address_id=" + address_id + ", address_line_1=" + address_line_1 + ", address_line_2="
				+ address_line_2 + ", city=" + city + ", state=" + state + ", pincode=" + pincode + ", type=" + type
				+ ", user=" + user + "]";
	}
}
