package com.hexaware.hotbyte.dto;

import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class MenuItemDto {
	
    private long menu_item_id;

    @NotBlank(message = "Menu item name cannot be blank")
    private String name;

    @NotBlank(message = "Cuisine type is required")
    @Pattern(regexp = "^(VEG|NON-VEG|BOTH)$",message = "Cuisine type must be VEG, NON-VEG, or BOTH")
    private String cuisine_type;

    @Size(max = 255, message = "Description should not exceed 255 characters")
    private String description;

    @NotBlank(message = "Image URL is required")
    @Pattern(regexp = "^(http|https)://.*$", message = "Image URL must be valid")
    private String image_url;

    @NotNull(message = "Price is required")
    @DecimalMin(value = "0.0",message = "Price must be greater than 0")
    private Double price;

    @NotBlank(message = "Preparation time is required")
    @Pattern(regexp = "^[0-9]+\\s?(minutes|min|hrs|hours)$",
             message = "Preparation time must be like '30 minutes' or '1 hr'")
    private String preparation_time;

    @NotBlank(message = "Availability status is required")
    @Pattern(regexp = "^(YES|NO)$",message = "Availability must be yes or no")
    private String is_available;

    @NotNull(message = "Restaurant ID is required")
    private int restaurant_id;

    @NotNull(message = "Category ID is required")
    private long category_id;

}
