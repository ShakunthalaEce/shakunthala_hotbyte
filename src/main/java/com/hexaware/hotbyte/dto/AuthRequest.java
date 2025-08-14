/*
 * Author: Shakunthala
 * Last Modified:13/8/25
 * Authentication Dto
 * 
 * Responsibility:
 * validations
*/
package com.hexaware.hotbyte.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AuthRequest {
    private String email;
    private String password;
}