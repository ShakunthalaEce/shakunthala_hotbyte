package com.hexaware.hotbyte.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class CategoryDto {
	
	private long category_id;

    @NotBlank(message = "Name cannot be blank")
    private String name;

    private String description;
}
