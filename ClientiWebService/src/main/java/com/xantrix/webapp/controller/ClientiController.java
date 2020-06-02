package com.xantrix.webapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.xantrix.webapp.domain.Cliente;
import com.xantrix.webapp.service.ClientiService;

import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping(value = "/api/clienti")
@Slf4j
public class ClientiController {
	@Autowired
	private ClientiService clientiService;
	
	@RequestMapping(value = "/", method = RequestMethod.GET, produces = "application/json")
	public ResponseEntity<Flux<Cliente>> getAllItems(){
		log.info("method getAllItems - START");
		log.info("method getAllItems - END");
		return new ResponseEntity<>(clientiService.findAll(), HttpStatus.OK);
	}

	@RequestMapping(value = "/addNewItem", method = RequestMethod.POST, produces = "application/json")
	public ResponseEntity<Mono<Cliente>> addNewItem(@RequestBody Cliente cliente){
		log.info("method addNewItem - START");
		log.info("cliente - {}", cliente);	
		log.info("method addNewItem - END");
		return new ResponseEntity(clientiService.save(cliente), HttpStatus.CREATED);
	}
}
