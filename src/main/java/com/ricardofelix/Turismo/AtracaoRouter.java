package com.ricardofelix.Turismo;

import org.springframework.context.annotation.Bean;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.server.RequestPredicates;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;

public class AtracaoRouter {
	
	@Bean
	public RouterFunction<ServerResponse> root(AtracaoHandler handler) {
		return RouterFunctions.route()
		  .GET("/atracoes", RequestPredicates.contentType(MediaType.APPLICATION_JSON), handler::findAll)
		  .GET("/atracoes/{id}",RequestPredicates.contentType(MediaType.APPLICATION_JSON), handler::findAll)
		  .POST("/atracoes",RequestPredicates.contentType(MediaType.APPLICATION_JSON), handler::findAll)
		  .DELETE("/atracoes/{id}", RequestPredicates.accept(MediaType.TEXT_PLAIN), handler::deleteById)
		  .build();
	}

		

}
