/*
 * Author: Shakunthala
 * Last Modified:13/8/25
 * OrderItem Dto
 * 
 * Responsibility:
 * validations
*/
package com.hexaware.hotbyte.dto;

import java.time.LocalDateTime;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderInfoDto {
	@Schema(accessMode = Schema.AccessMode.READ_ONLY)
	private long order_id; 

//    @NotNull(message = "Total amount is required")
//    @DecimalMin(value = "1.0",message = "Total amount must be at least 1")
//    private Double total_amount;

//    @NotNull(message = "Order time is required")
//    @PastOrPresent(message = "Order time cannot be in the future")
//    private LocalDateTime order_time; 

    @NotNull(message = "Order status is required")
    @Pattern(regexp = "^(PLACED|PREPARING|OUT_FOR_DELIVERY|DELIVERED|CANCELLED)$", message = "Status must be one of: PENDING, ACCEPTED, REJECTED")
    private String status; 

//    @NotNull(message = "User ID is required")
//    private long user_id;

    @NotNull(message = "Restaurant ID is required")
    private long restaurant_id;

    @NotNull(message = "Shipping address ID is required")
    private long shipping_address_id;
}
