package com.example.toyservice.converter

import com.example.toyservice.dto.ProductDto
import com.example.toyservice.model.Product
import org.springframework.core.convert.converter.Converter
import org.springframework.stereotype.Component

@Component
class ProductToDto: Converter<Product, ProductDto> {
    override fun convert(source: Product): ProductDto? {
        return ProductDto(source.id, source.name)
    }
}