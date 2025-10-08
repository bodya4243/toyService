package com.example.toyservice.security

import com.example.toyservice.dto.UserDto
import com.example.toyservice.repository.UserRepository
import mu.KLogging
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

    companion object : KLogging()

    fun authenticate(authentication: Authentication): UserDto {
        logger.info { "Authenticating user: ${authentication.name}" }

        val auth = manager.authenticate(authentication)

        val userEntity = userRepository.findByEmail(auth.name)
            .orElseThrow { RuntimeException("User not found after authentication") }

        return converter.convert(userEntity, UserDto::class.java)!!
    }

}