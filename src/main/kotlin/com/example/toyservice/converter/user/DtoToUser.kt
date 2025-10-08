package com.example.toyservice.converter.user

import com.example.toyservice.dto.UserDto
import com.example.toyservice.model.User
import org.springframework.core.convert.converter.Converter
import org.springframework.stereotype.Component

@Component
class DtoToUser : Converter<UserDto, User> {
    override fun convert(source: UserDto): User {
        val user = User(
            id = source.id,
            email = source.email
        )
        user.products = source.products?.toMutableList() ?: mutableListOf()
        return user
    }
}
