package com.example.toyservice.dto.auth

import jakarta.validation.constraints.NotBlank

data class UserLoginRequestDto(
    @field:NotBlank(message = "email is required")
    val email: String,

    @field:NotBlank(message = "password is required")
    var password: String
)