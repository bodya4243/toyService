package com.example.toyservice.controller

import com.example.toyservice.dto.ProductDto
import com.example.toyservice.service.ProductService
import jakarta.validation.Valid
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/products")
class ProductController(
    val productService: ProductService
) {

    @GetMapping("/{productId}")
    fun getProduct(@PathVariable productId: Long): ProductDto {
        return productService.findByProductId(productId)
    }

    @PostMapping
    fun addProduct(@Valid @RequestBody product: ProductDto): ProductDto {
        return productService.addProduct(product)
    }
}