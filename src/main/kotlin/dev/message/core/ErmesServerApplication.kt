package dev.message.core

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class ErmesServerApplication

fun main(args: Array<String>) {
	runApplication<ErmesServerApplication>(*args)
}
