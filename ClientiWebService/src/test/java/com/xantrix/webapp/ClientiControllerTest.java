package com.xantrix.webapp;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.reactive.WebFluxTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.reactive.server.WebTestClient;

import com.xantrix.webapp.controller.ClientiController;
import com.xantrix.webapp.domain.Cliente;
import com.xantrix.webapp.service.ClientiService;

@WebFluxTest(ClientiController.class)
public class ClientiControllerTest {

	@Autowired
	private WebTestClient wtc;	// oggetto che serve per testare il mio controller 'ClientiController'
	
	@MockBean
	private ClientiService clientiService;	
	
	
	private Cliente createCliente() {
		Cliente cliente = new Cliente();
		return cliente;
	}
	
	@Test
	public void testInsertCLI() throws Exception{
	
		Cliente cliente = this.createCliente();
	}
}