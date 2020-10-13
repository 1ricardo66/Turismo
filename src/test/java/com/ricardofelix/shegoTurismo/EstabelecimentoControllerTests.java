package com.ricardofelix.shegoTurismo;

import java.util.UUID;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.reactive.WebFluxTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Import;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.reactive.server.WebTestClient;
import org.springframework.web.reactive.function.BodyInserters;

import com.ricardofelix.shegoTurismo.controller.EstabelecimentoController;
import com.ricardofelix.shegoTurismo.document.Estabelecimento;
import com.ricardofelix.shegoTurismo.services.EstabelecimentoService;

import reactor.core.publisher.Mono;

@ExtendWith(SpringExtension.class)
@WebFluxTest(controllers = EstabelecimentoController.class)
@Import (EstabelecimentoService.class)
public class EstabelecimentoControllerTests {

	

	  @MockBean
	  EstabelecimentoService estabelecimentoService;
	  
	  @Autowired
	  WebTestClient webTestClient;
	  
	  
	  @Test
	  void inserirAtracaoTest() {
		  Estabelecimento estabelecimento = new Estabelecimento ("Salão do Tico", "64992929294");
		  Mockito.when(estabelecimentoService.saveEstabelecimento(estabelecimento)).
		  thenReturn(Mono.just(estabelecimento));
		  
		  webTestClient.post().uri("/estabelecimentos/")
		  .contentType(MediaType.APPLICATION_JSON)
		  .body(BodyInserters.fromValue(estabelecimento))
		  .exchange()
		  .expectStatus()
		  .isCreated();
		  
		  Mockito.verify(estabelecimentoService.saveEstabelecimento(estabelecimento));
		  }
	  
	  @Test
	  void encontrarAtracoesTest() {
		  Estabelecimento estabelecimento = new Estabelecimento ("Salão do Tico", "64992929294");
		  Mockito.when(estabelecimentoService.listEstabelecimentos())
		  .thenReturn(null);
		  
		  webTestClient.get().uri("/estabelecimentos/")
		  .exchange()
		  .expectStatus()
		  .isOk();
		  
		  Mockito.verify(estabelecimentoService).listEstabelecimentos();
	  }
	  

	  
	  
	  @Test
	  void deletarAtracaoTest() {
		  Estabelecimento estabelecimento = new Estabelecimento ("Salão do Tico", "64992929294");
		  final String uuid = UUID.randomUUID().toString();
		  estabelecimento.setId(uuid);
		  Mockito.when(estabelecimentoService.delete(uuid))
		  .thenReturn(null);
		  
		  webTestClient.get().uri("/estabelecimentos/"+uuid)
		  .exchange()
		  .expectStatus()
		  .isOk();
		  
		  Mockito.verify(estabelecimentoService).delete(uuid);
	  }
	  
	  
	  @Test
	  void encontrarAtracaoByIdTest() {
		  Estabelecimento estabelecimento = new Estabelecimento ("Salão do Tico", "64992929294");
		  final String uuid = UUID.randomUUID().toString();
		  estabelecimento.setId(uuid);
		  Mockito.when(estabelecimentoService.findById(uuid))
		  .thenReturn(Mono.just(estabelecimento));
		  
		  webTestClient.get().uri("/estabelecimentos/"+uuid)
		  .exchange()
		  .expectStatus()
		  .isOk();
		  
		  Mockito.verify(estabelecimentoService).findById(uuid);
	  }
}
