package com.consumir.client;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import com.consumir.dto.response.Episodio;

import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Mono;

@Service
@Slf4j
public class SimpsonClient {

	private final WebClient webClient;

	public SimpsonClient(WebClient.Builder builder) {
		webClient = builder.baseUrl("https://api.sampleapis.com/simpsons").build();
	}
	
	public Mono<Episodio>findAndEpisodioById(Long id){
		log.info("Buscando o episodio com o id [{}]", id);
		return webClient
				.get()
				.uri("/episodes/" + id)
				.accept(MediaType.APPLICATION_JSON)
				.retrieve()
				.onStatus(HttpStatus::is4xxClientError,
						error -> Mono.error(new RuntimeException("Verifique os parametros informados")))
				.bodyToMono(Episodio.class);
	}
}
