package com.example.toyservice.controller

import com.example.toyservice.dto.UserDto
import com.example.toyservice.dto.auth.UserLoginRequestDto
import com.example.toyservice.service.UserService
import org.springframework.http.HttpStatus
import mu.KLogging
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/auth")
class AuthController(
    val userService: UserService
) {

    companion object : KLogging()

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/registration")
    fun register(@RequestBody userDto: UserLoginRequestDto): UserDto {
        logger.info { "POST /auth/registration for ${userDto.email}" }
        return userService.register(userDto)
    }
}