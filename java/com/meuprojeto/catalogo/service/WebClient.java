package com.meuprojeto.catalogo.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;

@Configuration
public class WebClientConfig {

    @Value("${gutendex.api.url}") // URL base da API Gutendex, configurada em application.properties
    private String gutendexApiUrl;

    @Bean
    public WebClient webClient(WebClient.Builder builder) {
        return builder.baseUrl(gutendexApiUrl).build();
    }
}
