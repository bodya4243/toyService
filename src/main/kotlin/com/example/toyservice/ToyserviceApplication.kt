package com.example.toyservice

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class ToyserviceApplication

fun main(args: Array<String>) {
	runApplication<ToyserviceApplication>(*args)
}
