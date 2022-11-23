package com.last.dance.api.infrastructure.config

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.web.client.RestTemplate


@Configuration
class CoreBeanConfig {
    @Bean
    fun restTemplate(): RestTemplate = RestTemplate()
}
