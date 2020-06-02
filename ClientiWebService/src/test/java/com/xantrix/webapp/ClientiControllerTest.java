package com.xantrix.webapp;

import static org.mockito.Mockito.when;

import java.sql.Date;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.reactive.WebFluxTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.reactive.server.WebTestClient;

import com.xantrix.webapp.controller.ClientiController;
import com.xantrix.webapp.domain.Cards;
import com.xantrix.webapp.domain.Cliente;
import com.xantrix.webapp.service.ClientiService;

import reactor.core.publisher.Mono;

@WebFluxTest(ClientiController.class)
public class ClientiControllerTest {

	@Autowired
	private WebTestClient webTestClient;	// oggetto che serve per testare il mio controller 'ClientiController'
	
	@MockBean
	private ClientiService clientiService;	
	
	private Cliente createCliente() {
		Cliente cliente = new Cliente();
		cliente.setCodFid("650008986");
		cliente.setNominativo("Pippo Inzaghi");
		cliente.setIndirizzo("via Watt a la pesca, 19");
		cliente.setComune("Vimercate");
		cliente.setCap("98656");
		cliente.setProvincia("Vimercate");
		cliente.setDataCreazione(new Date(0));
		cliente.setAttivo(true);
		cliente.setMail("pippogol@email.it");
		cliente.setTelefono("3336689898");
		
		Cards cards = new Cards();
		cards.setBollini(150);
		cards.setUltimaSpesa("20-10-2018");
		
		cliente.setCards(cards);
		return cliente;
	}
	
	@Test
	public void testInsertCLI() throws Exception{
		Cliente cliente = this.createCliente();		
		
		Mono<Cliente> clienteMono = Mono.just(cliente); // quello che mi aspetto dal ritorno del metodo save  di 
		// quando chiamo il metodo save dell'oggetto clientiService, allora ritorna il contenuto della variabile clienteMono
		when(clientiService.save(cliente)).thenReturn(clienteMono);
	
		webTestClient.post()
			.uri("/api/clienti/addNewItem")
			.contentType(MediaType.APPLICATION_JSON)
			.accept(MediaType.APPLICATION_JSON)
			.body(clienteMono, Cliente.class)
			.exchange()
			.expectStatus().isCreated();
	}
}