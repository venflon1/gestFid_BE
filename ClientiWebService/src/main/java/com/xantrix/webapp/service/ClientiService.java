package com.xantrix.webapp.service;

import com.xantrix.webapp.domain.Cliente;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface ClientiService {
	
	public Flux<Cliente> findAll();
	
	public Mono<Cliente> findByNominativo(String nominativo);
	
	public Mono<Cliente> save(Cliente cliente);
	
	public Mono<Void> delete(String id);

}
