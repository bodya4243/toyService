package com.example.toyservice.converter.user

import com.example.toyservice.dto.UserDto
import com.example.toyservice.model.User
import org.springframework.core.convert.converter.Converter
import org.springframework.stereotype.Component

@Component
class UserToDto: Converter<User, UserDto>  {
    override fun convert(source: User): UserDto? {
        return UserDto(source.id, source.email, source.products)
    }
}