/*
 * Author: Shakunthala
 * Last Modified:13/8/25
 * Swagger Configuration
 
*/
package com.hexaware.hotbyte.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.annotations.enums.SecuritySchemeType;
import io.swagger.v3.oas.annotations.security.SecurityScheme;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;

@Configuration
@SecurityScheme(
    name = "Bearer Authentication",
    type = SecuritySchemeType.HTTP,
    bearerFormat = "JWT",
    scheme = "bearer"
)

public class SwaggerConfig {
	@Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
            .info(new Info().title("HotByte API").version("1.0"));
    }
}
