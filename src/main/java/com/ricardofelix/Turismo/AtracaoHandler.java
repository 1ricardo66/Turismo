package com.ricardofelix.Turismo;

import static org.springframework.web.reactive.function.BodyInserters.fromPublisher;
import static org.springframework.web.reactive.function.server.ServerResponse.ok;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import org.springframework.web.servlet.function.RouterFunctions;

import com.ricardofelix.Turismo.document.Atracao;
import com.ricardofelix.Turismo.repository.AtracaoRepository;
import com.ricardofelix.Turismo.services.AtracaoService;

import reactor.core.publisher.Mono;

public class AtracaoHandler {
	
	@Autowired
	AtracaoService service;
	
	public Mono<ServerResponse> findAll(ServerRequest request){
		return ok()
				.contentType(MediaType.APPLICATION_JSON)
				.body(service.listAtracoes(), Atracao.class);
	}
	
	public Mono<ServerResponse> findById(ServerRequest request){
		String id = request.pathVariable("id");
		return ok()
				.contentType(MediaType.APPLICATION_JSON)
				.body(service.findById(id), Atracao.class);
	}
	
	public Mono<ServerResponse> save(ServerRequest request){
		final Mono<Atracao> atracao = request.bodyToMono(Atracao.class);
		return ok()
				.contentType(MediaType.APPLICATION_JSON)
				.body(fromPublisher(atracao.flatMap(service::saveAtracao), Atracao.class));
	}

	public Mono<ServerResponse> deleteById(ServerRequest request) {
		return Mono.just(service.delete((request.pathVariable("id"))))
				.flatMap(val -> {
					return ServerResponse.noContent().build();
				});
	}
}

