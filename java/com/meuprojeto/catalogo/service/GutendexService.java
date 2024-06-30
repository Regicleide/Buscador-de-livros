package com.meuprojeto.catalogo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@Service
public class GutendexService {

    private final WebClient webClient;

    @Autowired
    public GutendexService(WebClient webClient) {
        this.webClient = webClient;
    }

    public Mono<String> buscarLivro(String termoBusca) {
        return webClient.get()
                .uri(uriBuilder -> uriBuilder.path("/volumes")
                        .queryParam("q", termoBusca)
                        .build())
                .retrieve()
                .bodyToMono(String.class);
    }
}
