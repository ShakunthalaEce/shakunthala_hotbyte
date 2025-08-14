/*
 * Author: Shakunthala
 * Last Modified:13/8/25
 * Cart Dto
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
public class CartDto {
	
	@Schema(accessMode = Schema.AccessMode.READ_ONLY)
    private long cart_id;

    @NotNull(message = "User ID cannot be null")
    @Min(value = 1, message = "User ID must be greater than 0")
    private long user_id;

    @NotNull(message = "Restaurant ID cannot be null")
    @Min(value = 1, message = "Restaurant ID must be greater than 0")
    private long res_id;
}
