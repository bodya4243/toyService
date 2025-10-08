package com.example.toyservice.config

import com.example.toyservice.converter.product.DtoToProduct
import com.example.toyservice.converter.product.ProductToDto
import com.example.toyservice.converter.user.DtoToUser
import com.example.toyservice.converter.user.LoginDtoToUser
import com.example.toyservice.converter.user.UserToDto
import org.springframework.context.annotation.Configuration
import org.springframework.format.FormatterRegistry
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer

@Configuration
class WebConfig : WebMvcConfigurer {

    override fun addFormatters(registry: FormatterRegistry) {
        registry.addConverter(ProductToDto())
        registry.addConverter(DtoToProduct())
        registry.addConverter(DtoToUser())
        registry.addConverter(UserToDto())
        registry.addConverter(LoginDtoToUser())
    }
}