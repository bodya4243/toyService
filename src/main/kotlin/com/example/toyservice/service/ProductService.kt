package com.example.toyservice.service

import com.example.toyservice.dto.ProductDto
import com.example.toyservice.model.User

interface ProductService {
    fun findByProductId(id: Long): ProductDto
    fun addProduct(productDto: ProductDto, currentUser: User): ProductDto
    fun deleteProduct(id: Long)
}