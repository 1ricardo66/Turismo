package com.ricardofelix.shegoTurismo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ricardofelix.shegoTurismo.document.Estabelecimento;
import com.ricardofelix.shegoTurismo.services.EstabelecimentoService;

import io.swagger.annotations.ApiOperation;
//import io.swagger.annotations.ApiOperation;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
public class EstabelecimentoController {

	
	@Autowired
	EstabelecimentoService estabelecimentoService;
	
	
	
	@ApiOperation(value = "Método para listar todos os estabelecimentos.")
	@GetMapping(value="/estabelecimentos")
	public Flux<Estabelecimento> listarEstabelecimentos() {
		return estabelecimentoService.listEstabelecimentos();
	}
	
	@ApiOperation(value = "Método para realizar o post de um estabelecimento.")
	@RequestMapping(value="/estabelecimentos", method = RequestMethod.POST)	
	public Mono <Estabelecimento> saveEstabelecimento(@RequestBody Estabelecimento estabelecimento) {
		return estabelecimentoService.saveEstabelecimento(estabelecimento);
		
	}
	
	@ApiOperation(value = "Método para realizar o get de um estabelecimento.")
	@RequestMapping(value= "/estabelecimentos/{id}", method = RequestMethod.GET)
	public Mono <Estabelecimento> listarCiclista(@PathVariable ("id") String id) {
		return estabelecimentoService.findById(id);
	}
	
	@ApiOperation(value = "Método para deletar um estabelecimento.")
	@RequestMapping(value= "/estabelecimentos/{id}", method = RequestMethod.DELETE)
	public Mono <Void> deleteEstabelecimento(@PathVariable ("id") String id) {
		return estabelecimentoService.delete(id);
	}
}
