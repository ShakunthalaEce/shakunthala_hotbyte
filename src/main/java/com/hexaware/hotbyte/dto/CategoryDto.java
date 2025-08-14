/*
 * Author: Shakunthala
 * Last Modified:13/8/25
 * Category Dto
 * 
 * Responsibility:
 * validations
*/
package com.hexaware.hotbyte.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class CategoryDto {
	
	@Schema(accessMode = Schema.AccessMode.READ_ONLY)
	private long category_id;

    @NotBlank(message = "Name cannot be blank")
    private String name;

    private String description;
}
