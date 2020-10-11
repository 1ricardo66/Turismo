package com.ricardofelix.shegoTurismo;

import static org.springframework.web.reactive.function.BodyInserters.fromPublisher;
import static org.springframework.web.reactive.function.server.ServerResponse.ok;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;

import com.ricardofelix.shegoTurismo.document.Estabelecimento;
import com.ricardofelix.shegoTurismo.services.EstabelecimentoService;

import reactor.core.publisher.Mono;

public class EstabelecimentoHandler {
	
	@Autowired
	EstabelecimentoService service;
	
	public Mono<ServerResponse> findAll(ServerRequest request){
		return ok()
				.contentType(MediaType.APPLICATION_JSON)
				.body(service.listEstabelecimentos(), Estabelecimento.class);
	}
	
	public Mono<ServerResponse> findById(ServerRequest request){
		String id = request.pathVariable("id");
		return ok()
				.contentType(MediaType.APPLICATION_JSON)
				.body(service.findById(id), Estabelecimento.class);
	}
	
	public Mono<ServerResponse> save(ServerRequest request){
		final Mono<Estabelecimento> atracao = request.bodyToMono(Estabelecimento.class);
		return ok()
				.contentType(MediaType.APPLICATION_JSON)
				.body(fromPublisher(atracao.flatMap(service::saveEstabelecimento), Estabelecimento.class));
	}

}
