package com.example.toyservice.security

import com.example.toyservice.dto.UserDto
import com.example.toyservice.repository.UserRepository
import org.springframework.core.convert.ConversionService
import org.springframework.security.core.Authentication
import org.springframework.security.authentication.AuthenticationManager
import org.springframework.stereotype.Service

@Service
class AuthService(
    private val manager: AuthenticationManager,
    private val userRepository: UserRepository,
    private val converter: ConversionService
) {
    fun authenticate(authentication: Authentication): UserDto {
        val auth = manager.authenticate(authentication)

        val userEntity = userRepository.findByEmail(auth.name)
            .orElseThrow { RuntimeException("User not found after authentication") }

        return converter.convert(userEntity, UserDto::class.java)!!
    }

}