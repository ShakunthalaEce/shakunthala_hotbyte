/*
 * Author: Shakunthala
 * Last Modified:13/8/25
 * OrderItem Dto
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
public class OrderItemDto {
	
	@Schema(accessMode = Schema.AccessMode.READ_ONLY)
	private long order_item_id; 

    @NotNull(message = "Quantity cannot be null")
    @Min(value = 1, message = "Quantity must be at least 1")
    private Integer quantity;

    @NotNull(message = "Price cannot be null")
    private Double price;

    @NotNull(message = "Order ID is required")
    private long orderId;

    @NotNull(message = "Menu item ID is required")
    private long menuItemId;
}
