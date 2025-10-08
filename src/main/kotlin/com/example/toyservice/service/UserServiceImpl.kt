package com.example.toyservice.service

import com.example.toyservice.dto.UserDto
import com.example.toyservice.dto.auth.UserLoginRequestDto
import com.example.toyservice.exception.UserNotFoundException
import com.example.toyservice.model.User
import com.example.toyservice.repository.UserRepository
import mu.KLogging
import org.springframework.core.convert.ConversionService
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.stereotype.Service
import kotlin.jvm.java

@Service
class UserServiceImpl(
    val userRepository: UserRepository,
    val converter: ConversionService,
    val passwordEncoder: PasswordEncoder
): UserService {

    companion object : KLogging()

    override fun register(userDto: UserLoginRequestDto): UserDto {
        return if (!userRepository.findByEmail(userDto.email).isPresent) {
            logger.info { "Registering new user with email=${userDto.email}" }

            val userEntity: User = converter.convert(userDto, User::class.java)!!
            userEntity.passwordField = passwordEncoder.encode(userDto.password)

            converter.convert(userRepository.save(userEntity), UserDto::class.java)!!
        } else {
            throw UserNotFoundException("user already exists")
        }
    }
}