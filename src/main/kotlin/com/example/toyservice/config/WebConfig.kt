package com.example.toyservice.config

import com.example.toyservice.converter.DtoToProduct
import com.example.toyservice.converter.ProductToDto
import org.springframework.context.annotation.Configuration
import org.springframework.format.FormatterRegistry
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer

@Configuration
class WebConfig : WebMvcConfigurer {

    override fun addFormatters(registry: FormatterRegistry) {
        registry.addConverter(ProductToDto())
        registry.addConverter(DtoToProduct())
    }
}