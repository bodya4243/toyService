package com.example.toyservice.converter.user

import com.example.toyservice.dto.auth.UserLoginRequestDto
import com.example.toyservice.model.User
import org.springframework.core.convert.converter.Converter
import org.springframework.stereotype.Component

@Component
class LoginDtoToUser : Converter<UserLoginRequestDto, User> {
    override fun convert(source: UserLoginRequestDto): User {
        return User(email = source.email, passwordField = source.password)
    }
}