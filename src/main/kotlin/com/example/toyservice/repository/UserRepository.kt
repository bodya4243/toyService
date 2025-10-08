package com.example.toyservice.repository

import com.example.toyservice.model.Product
import com.example.toyservice.model.User
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import java.util.Optional

interface UserRepository: JpaRepository<User, Long> {
    fun findByEmail(email: String?): Optional<User>
}