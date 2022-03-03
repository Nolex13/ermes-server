package dev.message.core.configurations

import dev.message.core.usecase.ProxyUseCase
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.web.client.RestTemplate

@Configuration
class ProxyConfiguration {
    @Bean
    fun proxyUseCase(
        restTemplate: RestTemplate
    ): ProxyUseCase =
        ProxyUseCase(restTemplate)
}