package com.example.toyservice.security

import com.example.toyservice.repository.UserRepository
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.stereotype.Service

@Service
class CustomUserDetailsService(
    val userRepository: UserRepository
): UserDetailsService {
    override fun loadUserByUsername(username: String?): UserDetails? {
        return userRepository.findByEmail(username).orElseThrow({
            RuntimeException("user not found by email: $username")
        })
    }
}