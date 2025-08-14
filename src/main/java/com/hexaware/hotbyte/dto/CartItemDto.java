/*
 * Author: Shakunthala
 * Last Modified:13/8/25
 * CartItem Dto
 * 
 * Responsibility:
 * validations
*/
package com.hexaware.hotbyte.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CartItemDto {
	
		
		@Schema(accessMode = Schema.AccessMode.READ_ONLY)
	    private long cart_item_id;

	    @NotNull(message = "Quantity cannot be null")
	    @Min(value = 1, message = "Quantity must be at least 1")
	    private int quantity;

	    @NotNull(message = "Cart ID cannot be null")
	    
	    private long cart_id;

	    @NotNull(message = "Menu Item ID cannot be null")
	    @Min(value = 1, message = "Menu Item ID must be greater than 0")
	    private long menu_item_id;
	
}
