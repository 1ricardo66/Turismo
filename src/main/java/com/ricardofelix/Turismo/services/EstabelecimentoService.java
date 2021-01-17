package com.ricardofelix.Turismo.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ricardofelix.Turismo.document.Estabelecimento;
import com.ricardofelix.Turismo.repository.EstabelecimentoRepository;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class EstabelecimentoService {

	@Autowired
	private EstabelecimentoRepository estabelecimentoRepository;
	
	
	public Flux<Estabelecimento> listEstabelecimentos(){
		return estabelecimentoRepository.findAll();
	}
	
	public Mono <Estabelecimento> saveEstabelecimento(Estabelecimento estabelecimento) {
		return estabelecimentoRepository.save(estabelecimento);
	}
	
	public Mono <Estabelecimento> findById(String id) {
		/*Optional<Estabelecimento> estabelecimento = estabelecimentoRepository.findById(id);
		return estabelecimento.orElse(null);*/
		
		return estabelecimentoRepository.findById(id);
	}
	
	
	public Mono<Void>  delete(String id) {
		return estabelecimentoRepository.deleteById(id);
	}
	
}
