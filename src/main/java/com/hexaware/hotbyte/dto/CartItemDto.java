package com.hexaware.hotbyte.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CartItemDto {
	
		@Min(value = 1, message = "Cart item ID must be greater than 0")
	    private long cart_item_id;

	    @NotNull(message = "Quantity cannot be null")
	    @Min(value = 1, message = "Quantity must be at least 1")
	    private int quantity;

	    @NotNull(message = "Cart ID cannot be null")
	    @Min(value = 1, message = "Cart ID must be greater than 0")
	    private long cart_id;

	    @NotNull(message = "Menu Item ID cannot be null")
	    @Min(value = 1, message = "Menu Item ID must be greater than 0")
	    private long menu_item_id;
	
}
