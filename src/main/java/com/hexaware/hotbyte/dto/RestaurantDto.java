package com.hexaware.hotbyte.dto;

import java.util.List;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RestaurantDto {
	
	 	private long restaurant_id;

	    @NotBlank(message = "Restaurant name is required")
	    @Size(max = 100, message = "Restaurant name must not exceed 100 characters")
	    private String restaurant_name;

	    @NotBlank(message = "Phone number is required")
	    @Pattern(regexp = "^[0-9]{10}$", message = "Phone number must be a 10-digit number")
	    private String phone_number;

	    @NotBlank(message = "City is required")
	    @Size(max = 50, message = "City must not exceed 50 characters")
	    private String city;

	    @NotBlank(message = "State is required")
	    @Size(max = 50, message = "State must not exceed 50 characters")
	    private String state;

	    @NotBlank(message = "Pincode is required")
	    @Pattern(regexp = "^[0-9]{6}$", message = "Pincode must be exactly 6 digits")
	    private String pincode;

	    @NotNull(message = "User ID is required")
	    private Long userId;

	    @NotNull(message = "Category IDs are required")
	    private List<Integer> categoryIds;
	
}
