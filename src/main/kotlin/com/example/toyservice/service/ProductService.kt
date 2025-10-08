package com.example.toyservice.service

import com.example.toyservice.dto.ProductDto

interface ProductService {
    fun findByProductId(id: Long): ProductDto
    fun addProduct(productDto: ProductDto): ProductDto
    fun deleteProduct(id: Long)
}