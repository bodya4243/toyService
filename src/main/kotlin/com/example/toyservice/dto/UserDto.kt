package com.example.toyservice.dto

import com.example.toyservice.model.Product
import jakarta.validation.constraints.NotBlank


data class UserDto (
    val id: Long?,

    @field:NotBlank(message = "email is required")
    val email: String,

    val products: MutableList<Product>?
)