/*
 * Author: Shakunthala
 * Last Modified:13/8/25
 * Address Dto
 * 
 * Responsibility:
 * validations
*/

package com.hexaware.hotbyte.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data 
@NoArgsConstructor 
@AllArgsConstructor 
public class AddressDto {
	    @Schema(accessMode = Schema.AccessMode.READ_ONLY)
	 	private long addressId;

	    @NotBlank(message = "Address line 1 cannot be empty")
	    @Size(max = 100, message = "Address line 1 should not exceed 100 characters")
	    private String addressLine1;

	    @Size(max = 100, message = "Address line 2 should not exceed 100 characters")
	    private String addressLine2;

	    @NotBlank(message = "City is required")
	    @Pattern(regexp = "^[A-Za-z ]+$", message = "City must contain only letters and spaces")
	    private String city;

	    @NotBlank(message = "State is required")
	    @Pattern(regexp = "^[A-Za-z ]+$", message = "State must contain only letters and spaces")
	    private String state;

	    @NotBlank(message = "Pincode is required")
	    @Pattern(regexp = "^[1-9][0-9]{5}$", message = "Pincode must be a valid 6-digit number")
	    private String pincode;

	    @NotBlank(message = "Type is required")
	    @Pattern(regexp = "^(Home|Work|Other)$", message = "Type must be Home, Work, or Other")
	    private String type;

	    @Schema(accessMode = Schema.AccessMode.READ_ONLY)
	    private long userId;
    
}
