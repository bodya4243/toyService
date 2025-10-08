package com.example.toyservice.converter.product

import com.example.toyservice.dto.ProductDto
import com.example.toyservice.model.Product
import org.springframework.core.convert.converter.Converter
import org.springframework.stereotype.Component

@Component
class DtoToProduct: Converter<ProductDto, Product> {
    override fun convert(source: ProductDto): Product? {
        return Product(source.id, source.name, source.category)
    }
}