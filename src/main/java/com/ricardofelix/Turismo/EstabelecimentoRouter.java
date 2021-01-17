package com.ricardofelix.Turismo;

import static org.springframework.web.reactive.function.server.RequestPredicates.GET;
import static org.springframework.web.reactive.function.server.RequestPredicates.POST;
import static org.springframework.web.reactive.function.server.RequestPredicates.accept;

import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.server.RequestPredicates;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;

public class EstabelecimentoRouter {
	//Bean
	public RouterFunction<ServerResponse> route(EstabelecimentoHandler handler){
		return RouterFunctions.route()
				  .GET("/estabelecimentos", RequestPredicates.contentType(MediaType.APPLICATION_JSON), handler::findAll)
				  .GET("/estabelecimentos/{id}",RequestPredicates.contentType(MediaType.APPLICATION_JSON), handler::findAll)
				  .POST("/estabelecimentos",RequestPredicates.contentType(MediaType.APPLICATION_JSON), handler::findAll)
				  .DELETE("/estabelecimentos/{id}", RequestPredicates.accept(MediaType.TEXT_PLAIN), handler::deleteById)
				  .build();
			
	}

}
