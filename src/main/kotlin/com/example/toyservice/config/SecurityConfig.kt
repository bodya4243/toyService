package com.example.toyservice.config

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

//@Configuration
//class SecurityConfig {
//    @Bean
//    fun securityFilterChain(http: HttpSecurity): SecurityFilterChain {
//        http
//            .csrf { it.disable() }
//            .authorizeHttpRequests {
//                it.requestMatchers("/public/**").permitAll()
//                it.anyRequest().authenticated()
//            }
//            .httpBasic { } // Увімкнення Basic Auth
//        return http.build()
//    }
//}