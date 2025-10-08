package com.example.toyservice.dto

import jakarta.validation.constraints.NotBlank

data class ProductDto (
    val id: Long? = null,

    @field:NotBlank(message = "name is required")
    val name: String,
)