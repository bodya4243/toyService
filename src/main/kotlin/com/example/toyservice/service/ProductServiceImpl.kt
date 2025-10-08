package com.example.toyservice.service

import com.example.toyservice.dto.ProductDto
import com.example.toyservice.model.Product
import com.example.toyservice.repository.ProductRepository
import org.springframework.core.convert.ConversionService
import org.springframework.stereotype.Service

@Service
class ProductServiceImpl(
    val productRepository: ProductRepository,
    val converter: ConversionService
): ProductService {
    override fun findByProductId(id: Long): ProductDto {
        val product = productRepository.findById(id)

        return if (product.isPresent) {
            converter.convert(product.get(), ProductDto::class.java)!!
        } else {
            throw RuntimeException("product with id $id not found")
        }
    }

    override fun addProduct(productDto: ProductDto): ProductDto {
        val productEntity: Product = converter.convert(productDto, Product::class.java)!!
        
        return converter.convert(productRepository.save(productEntity), ProductDto::class.java)!!
    }

    override fun deleteProduct(id: Long) {
        TODO("Not yet implemented")
    }

}