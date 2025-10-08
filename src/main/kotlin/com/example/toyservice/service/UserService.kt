package com.example.toyservice.service

import com.example.toyservice.dto.UserDto
import com.example.toyservice.dto.auth.UserLoginRequestDto

interface UserService {
    fun register(userDto: UserLoginRequestDto): UserDto
}