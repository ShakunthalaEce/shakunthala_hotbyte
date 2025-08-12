package com.hexaware.hotbyte.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderItemDto {
	private long order_item_id; 

    @NotNull(message = "Quantity cannot be null")
    @Min(value = 1, message = "Quantity must be at least 1")
    private Integer quantity;

    @NotNull(message = "Price cannot be null")
    private Double price;

    @NotNull(message = "Order ID is required")
    private Integer orderId;

    @NotNull(message = "Menu item ID is required")
    private Integer menuItemId;
}
