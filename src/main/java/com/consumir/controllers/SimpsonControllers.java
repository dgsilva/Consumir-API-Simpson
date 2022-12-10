package com.consumir.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.consumir.client.SimpsonClient;
import com.consumir.dto.response.Episodio;

import lombok.AllArgsConstructor;
import reactor.core.publisher.Mono;

@RestController
@AllArgsConstructor
@RequestMapping("/webclient")
public class SimpsonControllers {

	SimpsonClient simpsonClient;
	
	@GetMapping("/episodes/{id}")
	public Mono<Episodio> getEpisodio(@PathVariable Long id){
		return simpsonClient.findAndEpisodioById(id);
	}
}
