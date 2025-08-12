package com.hexaware.hotbyte.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CartDto {
	
	@Min(value = 1, message = "Cart ID must be greater than 0")
    private long cart_id;

    @NotNull(message = "User ID cannot be null")
    @Min(value = 1, message = "User ID must be greater than 0")
    private int user_id;

    @NotNull(message = "Restaurant ID cannot be null")
    @Min(value = 1, message = "Restaurant ID must be greater than 0")
    private int res_id;
}
