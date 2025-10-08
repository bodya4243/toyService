package com.example.toyservice.controller

import com.example.toyservice.dto.ProductDto
import com.example.toyservice.model.User
import com.example.toyservice.service.ProductService
import jakarta.validation.Valid
import org.springframework.http.HttpStatus
import org.springframework.security.core.annotation.AuthenticationPrincipal
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/products")
class ProductController(
    val productService: ProductService
) {

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/{productId}")
    fun getProduct(@PathVariable productId: Long): ProductDto {
        return productService.findByProductId(productId)
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    fun addProduct(@Valid @RequestBody product: ProductDto, @AuthenticationPrincipal user: User): ProductDto {
        return productService.addProduct(product, user)
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{productId}")
    fun deleteProduct(@PathVariable productId: Long){
        productService.deleteProduct(productId)
    }
}