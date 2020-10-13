package com.ricardofelix.shegoTurismo.services;

import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ricardofelix.shegoTurismo.document.Atracao;
import com.ricardofelix.shegoTurismo.repository.AtracaoRepository;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;


@Service
public class AtracaoService {

	
	@Autowired
	private AtracaoRepository atracaoRepository;
	
	
	public Flux<Atracao> listAtracoes(){
		return atracaoRepository.findAll();
	}
	
	public Mono<Atracao> saveAtracao(Atracao atracao) {
		return atracaoRepository.save(atracao);
	}
	
	public Mono<Atracao> findById(String id) {
		/*Optional<Estabelecimento> estabelecimento = estabelecimentoRepository.findById(id);
		return estabelecimento.orElse(null);*/
		
		return atracaoRepository.findById(id);
	}
	
	
	
	
	
	
    public Mono<Void> delete ( String id) {
    	
    	return atracaoRepository.deleteById(id);
    	
    }
    
    
}
