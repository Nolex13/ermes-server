package dev.message.core.configurations

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.web.client.RestTemplate

@Configuration
class CommonConfiguration {
    @Bean
    fun restTemplate(): RestTemplate =
        RestTemplate()
}