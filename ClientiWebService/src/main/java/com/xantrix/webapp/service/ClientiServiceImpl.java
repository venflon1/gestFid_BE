package com.xantrix.webapp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xantrix.webapp.domain.Cliente;
import com.xantrix.webapp.repository.ClienteRepository;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class ClientiServiceImpl implements ClientiService{

	@Autowired
	private ClienteRepository clienteRepo;
	
	@Override
	public Flux<Cliente> findAll() {
		return clienteRepo.findAll();
	}

	@Override
	public Mono<Cliente> findByNominativo(String nominativo) {
		return clienteRepo.findByNominativo(nominativo);
	}

	@Override
	public Mono<Cliente> save(Cliente cliente) {
		return clienteRepo.insert(cliente);
	}

	@Override
	public Mono<Void> delete(String id) {
		return clienteRepo.deleteById(id);
	}
}
