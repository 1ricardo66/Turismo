package com.ricardofelix.Turismo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ricardofelix.Turismo.document.Atracao;
import com.ricardofelix.Turismo.services.AtracaoService;

import io.swagger.annotations.ApiOperation;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@CrossOrigin(origins = "*")
@RestController
public class AtracaoController {
	
	
	@Autowired
	AtracaoService atracaoService;
	
	

	
	@ApiOperation(value = "Método para listar todas as Atrações.")
	@GetMapping("/atracoes")
	public Flux<Atracao> listarEstabelecimentos() {
		return atracaoService.listAtracoes();
	}
	
	@ApiOperation(value = "Método para realizar o post de uma atração.")
	@RequestMapping(value = "/atracoes", method = RequestMethod.POST)	
	public Mono<Atracao> saveAtracoes(@RequestBody Atracao atracao) {
		return atracaoService.saveAtracao(atracao);
		
	}
	
	@ApiOperation(value = "Método para realizar o get de uma atração.")
	@RequestMapping(value= "/atracoes/{id}", method = RequestMethod.GET)
	public Mono<Atracao> listarAtracoes(@PathVariable ("id") String id) {
		return atracaoService.findById(id);
	}
	
	@ApiOperation(value = "Método para realizar a exclusão de uma atração.")
	@DeleteMapping("/atracoes/{id}")
	public Mono<Void> deleteAtracoes(@PathVariable ("id") String id) {
		return atracaoService.delete(id);
		
	}
	

}
