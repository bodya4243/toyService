package com.example.toyservice.service

import com.example.toyservice.dto.ProductDto
import com.example.toyservice.exception.ProductNotFoundException
import com.example.toyservice.exception.UserNotFoundException
import com.example.toyservice.model.Product
import com.example.toyservice.model.User
import com.example.toyservice.repository.ProductRepository
import com.example.toyservice.repository.UserRepository
import org.springframework.core.convert.ConversionService
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class ProductServiceImpl(
    val productRepository: ProductRepository,
    val userRepository: UserRepository,
    val converter: ConversionService
): ProductService {
    override fun findByProductId(id: Long): ProductDto {
        val product = productRepository.findById(id)

        return if (product.isPresent) {
            converter.convert(product.get(), ProductDto::class.java)!!
        } else {
            throw ProductNotFoundException("product with id $id not found")
        }
    }

    @Transactional
    override fun addProduct(productDto: ProductDto, currentUser: User): ProductDto {
        val productEntity: Product = converter.convert(productDto, Product::class.java)!!

        val userFromDb: User = userRepository.findByEmail(currentUser.email)
            .orElseThrow { UserNotFoundException("User with email: ${currentUser.email} not found") }

        productEntity.user = userFromDb
        userFromDb.products.add(productEntity)

        return converter.convert(productEntity, ProductDto::class.java)!!
    }

    override fun deleteProduct(id: Long) {
        if (productRepository.findById(id).isPresent) {
            productRepository.deleteById(id)
        } else {
            throw ProductNotFoundException("product with id $id not found")
        }
    }

}