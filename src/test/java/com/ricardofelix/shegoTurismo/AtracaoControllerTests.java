/*package com.ricardofelix.shegoTurismo;

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

import com.ricardofelix.Turismo.controller.AtracaoController;
import com.ricardofelix.Turismo.document.Atracao;
import com.ricardofelix.Turismo.services.AtracaoService;

import reactor.core.publisher.Mono;

@ExtendWith(SpringExtension.class)
@WebFluxTest(controllers = AtracaoController.class)
@Import (AtracaoService.class)
public class AtracaoControllerTests {

  @MockBean
  AtracaoService atracaoService;
  
  @Autowired
  WebTestClient webTestClient;
  
  
  @Test
  void inserirAtracaoTest() {
	  Atracao atracao = new Atracao ("Santa Helena", "Descrição nota 10");
	  Mockito.when(atracaoService.saveAtracao(atracao)).
	  thenReturn(Mono.just(atracao));
	  
	  webTestClient.post().uri("/atracoes/")
	  .contentType(MediaType.APPLICATION_JSON)
	  .body(BodyInserters.fromValue(atracao))
	  .exchange()
	  .expectStatus().isCreated();
	  
	  Mockito.verify(atracaoService.saveAtracao(atracao));
	  }
  
  @Test
  void encontrarAtracoesTest() {
	  Atracao atracao = new Atracao ("Santa Helena", "Descrição nota 10");
	  Mockito.when(atracaoService.listAtracoes())
	  .thenReturn(null);
	  
	  webTestClient.get().uri("/atracoes/")
	  
	  .exchange()
	  .expectStatus()
	  .isOk();
	  
	  Mockito.verify(atracaoService).listAtracoes();
  }
  

  
  
  @Test
  void deletarAtracaoTest() {
	  Atracao atracao = new Atracao ("Santa Helena", "Descrição nota 10");
	  final String uuid = UUID.randomUUID().toString();
	  atracao.setId(uuid);
	  Mockito.when(atracaoService.delete(uuid))
	  .thenReturn(null);
	  
	  webTestClient.get().uri("/atracoes/"+uuid)
	  
	  .exchange()
	  .expectStatus()
	  .isOk();
	  
	  Mockito.verify(atracaoService).delete(uuid);
  }
  
  
  @Test
  void encontrarAtracaoByIdTest() {
	  Atracao atracao = new Atracao ("Santa Helena", "Descrição nota 10");
	  final String uuid = UUID.randomUUID().toString();
	  atracao.setId(uuid);
	  Mockito.when(atracaoService.findById(uuid))
	  .thenReturn(Mono.just(atracao));
	  
	  webTestClient.get().uri("/atracoes/"+uuid)
	  .exchange()
	  .expectStatus()
	  .isOk();
	  
	  Mockito.verify(atracaoService).findById(uuid);
  }
  
  
	
	
}*/