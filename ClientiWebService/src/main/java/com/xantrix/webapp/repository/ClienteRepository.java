package com.xantrix.webapp.repository;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

import com.xantrix.webapp.domain.Cliente;

import reactor.core.publisher.Mono;

public interface ClienteRepository extends ReactiveMongoRepository<Cliente, String>{

	public Mono<Cliente> findByNominativo(String nominativo);
}
